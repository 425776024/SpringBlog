package com.xin.service;

import com.xin.model.Category;
import com.xin.model.Comment;
import com.xin.model.Post;
import com.xin.model.User;
import org.springframework.dao.DataAccessException;

import java.util.Collection;
import java.util.List;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午10:03
 */
public interface SpringBlogService {


    Long saveUser(User user) throws DataAccessException;

    User findUserById(Long id) throws DataAccessException;

    User findUserByName(String name) throws DataAccessException;

    Collection<User> findAllUser() throws DataAccessException;


    Long savePost(Post post) throws DataAccessException;

    Post findPostById(Long id) throws DataAccessException;

    Collection<Post> findAllPost() throws DataAccessException;
    Collection<Post> findAllPostByCategoryId(Long id) throws DataAccessException;

    void deleteAllPost() throws DataAccessException;

    void deletePost(Long id) throws DataAccessException;



    Long saveCategory(Category category) throws  DataAccessException;

    Category findCategoryById(Long id) throws  DataAccessException;

    Collection<Category> findAllCategory() throws DataAccessException;

    void deleteCategory(Long id) throws DataAccessException;


    Long saveComment(Comment comment) throws DataAccessException;

    Comment findCommentById(Long id) throws DataAccessException;

    Collection<Comment> findAllComment() throws DataAccessException;

    Collection<Comment> findCommentByPostId(Long postId) throws DataAccessException;

    void deleteComment(Long id) throws DataAccessException;

}
