package com.xin.repository.impl;

import com.xin.model.Category;
import com.xin.repository.CategoryRepo;
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
 * Time: 上午8:55
 */
@Repository
public class CategoryRepoImpl implements CategoryRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(Category category) throws DataAccessException {

        Long id = category.getCatId();
        if(id == null){
            id = (Long) this.getCurrentSession().save(category);
        }else {
            this.getCurrentSession().update(category);
        }
        return id;
    }

    @Override
    public Category find(Long id) throws DataAccessException {
        return (Category) this.getCurrentSession().get(Category.class, id);
    }

    @Override
    public Collection<Category> findAll() throws DataAccessException {

        Query query =  this.sessionFactory.getCurrentSession().createQuery("from Category");

        return  query.list();
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        Query query =  this.getCurrentSession().createQuery("delete Category where catId=?");
        query.setLong(0,id);
        query.executeUpdate();
    }
}
