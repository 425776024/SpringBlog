package com.xin.service.impl;

import com.xin.model.Category;
import com.xin.model.Comment;
import com.xin.model.Post;
import com.xin.model.User;
import com.xin.repository.CategoryRepo;
import com.xin.repository.CommentRepo;
import com.xin.repository.PostRepo;
import com.xin.repository.UserRepo;
import com.xin.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午10:06
 */

@Service
public class SpringBlogServiceImpl implements SpringBlogService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CommentRepo commentRepo;


    @Transactional
    @Override
    public Long saveUser(User user) throws DataAccessException {
        return this.userRepo.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Long id) throws DataAccessException {
        return this.userRepo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserByName(String name) throws DataAccessException {
        return this.userRepo.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<User> findAllUser() throws DataAccessException {
        return this.userRepo.findAll();
    }


    @Transactional
    @Override
    public Long savePost(Post posts) throws DataAccessException {
        return this.postRepo.save(posts);
    }


    @Transactional(readOnly = true)
    @Override
    public Post findPostById(Long id) throws DataAccessException {
        return this.postRepo.find(id);
    }


    @Transactional(readOnly = true)
    @Override
    public Collection<Post> findAllPost() throws DataAccessException {
        return this.postRepo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Post> findAllPostByCategoryId(Long id) throws DataAccessException {
        return this.postRepo.findAllByCategoryId(id);
    }

    @Transactional
    @Override
    public void deleteAllPost() throws DataAccessException {

    }

    @Transactional
    @Override
    public void deletePost(Long id) throws DataAccessException {
        this.postRepo.delete(id);
    }

    @Transactional
    @Override
    public Long saveCategory(Category category) throws DataAccessException {
        return this.categoryRepo.save(category);
    }

    @Transactional(readOnly = true)
    @Override
    public Category findCategoryById(Long id) throws DataAccessException {
        return this.categoryRepo.find(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Category> findAllCategory() throws DataAccessException {
        return categoryRepo.findAll();
    }

    @Transactional
    @Override
    public void deleteCategory(Long id) throws DataAccessException {
        this.categoryRepo.delete(id);
    }

    @Transactional
    @Override
    public Long saveComment(Comment comment) throws DataAccessException {
        return this.commentRepo.save(comment);
    }

    @Transactional(readOnly = true)
    @Override
    public Comment findCommentById(Long id) throws DataAccessException {
        return this.commentRepo.find(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Comment> findAllComment() throws DataAccessException {
        return this.commentRepo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Comment> findCommentByPostId(Long postId) throws DataAccessException {
        return this.commentRepo.findCommentByPostId(postId);
    }

    @Transactional
    @Override
    public void deleteComment(Long id) throws DataAccessException {
        this.commentRepo.delete(id);
    }
}
