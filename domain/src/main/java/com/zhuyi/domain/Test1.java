package com.zhuyi.domain;

import java.io.Serializable;
import java.util.Date;

public class Test1 implements Serializable{


    private static final long serialVersionUID = 1209007007790225828L;
    private String property1;
    private Date property2;
    private Long property3;
    private Integer property4;
    private Boolean property5;
    private Test2 prroperty6;

    public Test1(){}

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public Date getProperty2() {
        return property2;
    }

    public void setProperty2(Date property2) {
        this.property2 = property2;
    }

    public Long getProperty3() {
        return property3;
    }

    public void setProperty3(Long property3) {
        this.property3 = property3;
    }

    public Integer getProperty4() {
        return property4;
    }

    public void setProperty4(Integer property4) {
        this.property4 = property4;
    }

    public Boolean getProperty5() {
        return property5;
    }

    public void setProperty5(Boolean property5) {
        this.property5 = property5;
    }

    public Test2 getPrroperty6() {
        return prroperty6;
    }

    public void setPrroperty6(Test2 prroperty6) {
        this.prroperty6 = prroperty6;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "property1='" + property1 + '\'' +
                ", property2=" + property2 +
                ", property3=" + property3 +
                ", property4=" + property4 +
                ", property5=" + property5 +
                ", prroperty6=" + prroperty6 +
                '}';
    }
}
