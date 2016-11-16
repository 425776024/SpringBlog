package com.springmvchibernate.repository.impl;

import com.springmvchibernate.model.Post;
import com.springmvchibernate.repository.PostRepo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-7
 * Time: 下午3:23
 */
@Repository
public class PostRepoImpl implements PostRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(Post post) throws DataAccessException {

        Long id = post.getPostId();

        if(id == null){
            id = (Long) this.getCurrentSession().save(post);
        }else {
            this.getCurrentSession().update(post);
        }

        return id;
    }

    @Override
    public Post find(Long id) throws DataAccessException {
        return (Post) this.getCurrentSession().get(Post.class, id);
    }

    @Override
    public Collection<Post> findAll() throws DataAccessException {

        Query query =  this.sessionFactory.getCurrentSession().createQuery("from Post");

        return  query.list();
    }

    @Override
    public Collection<Post> findAllByCategoryId(Long categoryId) throws DataAccessException {
        Query query =  this.sessionFactory.getCurrentSession().createQuery("from Post p where p.categoryId=?");
        query.setLong(0,categoryId);
        return  query.list();
    }

    @Override
    public void delete(Long id) throws DataAccessException {

        Query query =  this.sessionFactory.getCurrentSession().createQuery("delete Post where postId=?");
        query.setLong(0,id);
        query.executeUpdate();
    }
}
