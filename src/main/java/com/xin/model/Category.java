package com.xin.model;

import javax.persistence.*;

/**
 * User: Xin
 * Date: 14-5-4
 * Time: 下午10:27
 */
@Entity
public class Category {

    public Category() {
    }

    public Category(Long catId, String catName, String catDescription, Long catParent) {
        this.catId = catId;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catParent = catParent;
    }

    private Long catId;

    @javax.persistence.Column(name = "cat_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    private String catName;

    @javax.persistence.Column(name = "cat_name")
    @Basic
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    private String catDescription;

    @javax.persistence.Column(name = "cat_description")
    @Basic
    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }
 
    private Long catParent;

    @javax.persistence.Column(name = "cat_parent")
    @Basic
    public Long getCatParent() {
        return catParent;
    }

    public void setCatParent(Long catParent) {
        this.catParent = catParent;
    }

}
