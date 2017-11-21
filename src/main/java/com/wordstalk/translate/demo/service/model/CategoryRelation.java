package com.wordstalk.translate.demo.service.model;

import java.util.Date;

import com.wordstalk.translate.demo.dao.entity.Category;

/**
 * 封装了个属性isMiddle，判断id是否为总数的中间，演示用，没意思
 */
public class CategoryRelation {

    private Integer id;
    private String name;
    private Boolean isMiddle;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean isMiddle() {
        return this.isMiddle;
    }

    public CategoryRelation(Category category, Integer totalCount) {
        if (category == null || totalCount == null) {
            return;
        }

        this.id = category.getId();
        this.name = category.getName();
        this.date = new Date();
        isMiddle = totalCount / 2 == id ? true : false;
    }
}
