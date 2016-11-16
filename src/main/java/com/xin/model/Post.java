package com.xin.model;

import javax.persistence.*;
import java.util.Date;


/**
 * User: Xin
 * Date: 14-5-4
 * Time: 下午10:27
 */
@Entity
public class Post {

    public Post() {
    }

    public Post(Long postId, Long authorId, Date postDate, String postContent, String postTitle, Integer postStatus, Integer commentStatus, Long categoryId, Date postModifiedDate, Integer commentCount) {
        this.postId = postId;
        this.authorId = authorId;
        this.postDate = postDate;
        this.postContent = postContent;
        this.postTitle = postTitle;
        this.postStatus = postStatus;
        this.commentStatus = commentStatus;
        this.categoryId = categoryId;
        this.postModifiedDate = postModifiedDate;
        this.commentCount = commentCount;
    }

    private Long postId;

    @javax.persistence.Column(name = "post_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    private Long authorId;

    @javax.persistence.Column(name = "author_id")
    @Basic
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    private Date postDate;

    @javax.persistence.Column(name = "post_date")
    @Basic
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    private String postContent;

    @javax.persistence.Column(name = "post_content")
    @Basic
    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    private String postTitle;

    @javax.persistence.Column(name = "post_title")
    @Basic
    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    private Integer postStatus;

    @javax.persistence.Column(name = "post_status")
    @Basic
    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    private Integer commentStatus;

    @javax.persistence.Column(name = "comment_status")
    @Basic
    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    private Long categoryId;

    @javax.persistence.Column(name = "category_id")
    @Basic
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    private Date postModifiedDate;

    @javax.persistence.Column(name = "post_modified_date")
    @Basic
    public Date getPostModifiedDate() {
        return postModifiedDate;
    }

    public void setPostModifiedDate(Date postModifiedDate) {
        this.postModifiedDate = postModifiedDate;
    }

    private Integer commentCount;

    @javax.persistence.Column(name = "comment_count")
    @Basic
    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }


}
