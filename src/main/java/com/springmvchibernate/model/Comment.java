package com.springmvchibernate.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 评论
 */
@Entity
public class Comment {

    public Comment() {
    }

    /**
     *
     * @param commentId 评论id
     * @param postId    帖子id
     * @param commentAuthor 评论者
     * @param commentAuthorEmail    评论者邮箱
     * @param commentDate   评论时间
     * @param commentContent    评论内容
     * @param commentParent 评论的上级
     * @param userId    用户id
     */
    public Comment(Long commentId, Long postId, String commentAuthor, String commentAuthorEmail, Date commentDate, String commentContent, Long commentParent, Long userId) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentAuthor = commentAuthor;
        this.commentAuthorEmail = commentAuthorEmail;
        this.commentDate = commentDate;
        this.commentContent = commentContent;
        this.commentParent = commentParent;
        this.userId = userId;
    }

    private Long commentId;

    @Column(name = "comment_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    private Long postId;

    @Column(name = "post_id")
    @Basic
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    private String commentAuthor;

    @Column(name = "comment_author")
    @Basic
    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    private String commentAuthorEmail;

    @Column(name = "comment_author_email")
    @Basic
    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    private Date commentDate;

    @Column(name = "comment_date")
    @Basic
    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    private String commentContent;

    @Column(name = "comment_content")
    @Basic
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    private Long commentParent;

    @Column(name = "comment_parent")
    @Basic
    public Long getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    private Long userId;

    @Column(name = "user_id")
    @Basic
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
