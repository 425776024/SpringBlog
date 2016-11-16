package com.springmvchibernate.repository;

import com.springmvchibernate.model.Post;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午9:44
 */
public interface PostRepo {

    Long save(Post post) throws DataAccessException;

    Post find(Long id) throws DataAccessException;

    Collection<Post> findAll() throws DataAccessException;
    Collection<Post> findAllByCategoryId(Long categoryId) throws DataAccessException;

    void delete(Long id) throws DataAccessException;

}
