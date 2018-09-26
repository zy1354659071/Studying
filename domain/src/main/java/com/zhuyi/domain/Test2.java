package com.zhuyi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuyi8
 * created on 2018/9/25
 */
public class Test2 implements Serializable{
    private static final long serialVersionUID = 1670937414121799287L;
    private Long property1;
    private String property2;
    private Date property3;

    public Test2(){}

    public Long getProperty1() {
        return property1;
    }

    public void setProperty1(Long property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public Date getProperty3() {
        return property3;
    }

    public void setProperty3(Date property3) {
        this.property3 = property3;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "property1=" + property1 +
                ", property2='" + property2 + '\'' +
                ", property3=" + property3 +
                '}';
    }
}
