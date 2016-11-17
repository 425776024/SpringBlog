package com.springmvchibernate.model;

import javax.persistence.*;

/**
 *分类表
 */
@Entity
public class Category {

    public Category() {
    }

    /**
     *
     * @param catId 分类id
     * @param catName   分类名称
     * @param catDescription    分类描述
     * @param catParent 分类父级
     */
    public Category(Long catId, String catName, String catDescription, Long catParent) {
        this.catId = catId;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catParent = catParent;
    }

    private Long catId;

    @Column(name = "cat_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    private String catName;

    @Column(name = "cat_name")
    @Basic
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    private String catDescription;

    @Column(name = "cat_description")
    @Basic
    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }
 
    private Long catParent;

    @Column(name = "cat_parent")
    @Basic
    public Long getCatParent() {
        return catParent;
    }

    public void setCatParent(Long catParent) {
        this.catParent = catParent;
    }

}
