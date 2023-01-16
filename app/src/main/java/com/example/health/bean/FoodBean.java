package com.example.health.bean;

import java.io.Serializable;

/**
 * @PackageName: com.example.health.bean
 * @ClassName: FoodBean
 * @Author: winwa
 * @Date: 2023/1/14 20:48
 * @Description:
 **/
public class FoodBean implements Serializable {
    private String title;
    private String conflict;
    private String desc;
    private int picId;

    public FoodBean(String title, String conflict, String desc, int picId) {
        this.title = title;
        this.conflict = conflict;
        this.desc = desc;
        this.picId = picId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConflict() {
        return conflict;
    }

    public void setConflict(String conflict) {
        this.conflict = conflict;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }
}
