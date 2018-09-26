package com.zhuyi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 为类自动注入属性
 * @author zhuyi8
 * @param <T>
 */
public final class ClassFactoryUtils<T> {

    private static final Logger log = LoggerFactory.getLogger(ClassFactoryUtils.class);

    public static Random random = null;

    static {
        random = new Random();
    }

    /**
     * 获得随机的字符串长度
     * @param length
     * @return
     */
    private static String getRandomString(int length){
        String allString = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWSYZ";
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<length;i++){
            stringBuilder.append(allString.charAt(random.nextInt(allString.length())));
        }
        return  stringBuilder.toString();
    }

    private static Date getRandomDate(){
        Calendar calendar = Calendar.getInstance();
        long seconds = calendar.getTime().getTime();
        return new Date(seconds - random.nextInt(2*365*24*60*60) );
    }

    public static <T> T createObject(Class<T> clazz){
        T t = null;
        try{
            t = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                String fieldName = field.getType().getName();
                if(fieldName.indexOf("String") >= 0){
                    field.set(t, getRandomString(random.nextInt(2))+4);
                }else if(fieldName.indexOf("Date") >= 0){
                    field.set(t, getRandomDate());
                }else if(fieldName.indexOf("Boolean") >= 0 ){
                    field.set(t,System.currentTimeMillis()/2 == 0 ? true : false );
                }else if(fieldName.indexOf("Integer") >= 0){
                    field.set(t, random.nextInt(100));
                }else if(fieldName.indexOf("Long") >= 0){
                    field.set(t, random.nextLong());
                }
            }

        }catch (Exception e){
            log.error("创建对象失败！", e);
        }
        return t;
    }

    public static  <T, M> T createObject(Class<T> clazz1, Class<M> clazz2){
        T t = createObject(clazz1);
        M m = createObject(clazz2);

        try{
            if(t == null){
                return  null;
            }else{
                Field[] fields = clazz1.getDeclaredFields();
                for(Field field : fields){
                    field.setAccessible(true);
                    if(field.getType().getName().indexOf(clazz2.getName()) >= 0){
                        field.set(t, m);
                    }
                }
            }
        }catch (Exception e){
            log.error("创建对象出错", e);
        }
        return t;
    }


}
