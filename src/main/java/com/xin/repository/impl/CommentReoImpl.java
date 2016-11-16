package com.xin.repository.impl;

import com.xin.model.Comment;
import com.xin.repository.CommentRepo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * User: Xin
 * Date: 14-5-10
 * Time: 上午9:00
 */

@Repository
public class CommentReoImpl implements CommentRepo{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    @Override
    public Long save(Comment comment) throws DataAccessException {
        Long id = comment.getCommentId();
        if(id == null){
            id = (Long) this.getCurrentSession().save(comment);
        }else{
            this.getCurrentSession().update(comment);
        }
        return id;
    }

    @Override
    public Comment find(Long id) throws DataAccessException {
        return (Comment) this.getCurrentSession().get(Comment.class, id);
    }

    @Override
    public Collection<Comment> findAll() throws DataAccessException {

        Query query =  this.sessionFactory.getCurrentSession().createQuery("from Comment");

        return  query.list();
    }

    @Override
    public Collection<Comment> findCommentByPostId(Long postId) throws DataAccessException {

        Query query =  this.sessionFactory.getCurrentSession().createQuery("from Comment where postId=?");
        query.setLong(0,postId);

        return  query.list();
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        Query query =  this.getCurrentSession().createQuery("delete Comment where commentId=?");
        query.setLong(0,id);
        query.executeUpdate();
    }
}
