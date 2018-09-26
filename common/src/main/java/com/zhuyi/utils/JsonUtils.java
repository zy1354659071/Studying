package com.zhuyi.utils;


import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 进行Json相关的操作
 * @author zhuyi8
 * created on 2018/9/25 20:04:00
 */
public final class JsonUtils {

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
    public static Gson gson = null;
    static{
        if(gson == null){
            gson = new Gson();
        }
    }

    private JsonUtils(){}

    /**
     * 将object转化成json字符串
     * @param object
     * @return
     */
    public static String toJson(Object object){
        String jsonString = null;
        try {
            if(gson != null){
                jsonString = gson.toJson(object);
            }
        }catch (Exception e){
            log.error("调用Gson的toJson框架出错，object=" + object.toString());
        }

        return jsonString;
    }

    /**
     * 将String转化对象
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonString, Class<T> clazz){
        T t = null;
        try {
            if(gson != null){
                t = gson.fromJson(jsonString, clazz);
            }
        }catch (Exception e){
            log.error("调用Gson的fromJson方法框架出错,object=" + jsonString.toString()+ " class=" + clazz.getName());
        }
        return t;
    }

    //public static <T> List<T> toList()

}
