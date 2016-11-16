package com.xin.repository;

import com.xin.model.Category;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午9:51
 */
public interface CategoryRepo {


    Long save(Category category) throws DataAccessException;

    Category find(Long id) throws DataAccessException;

    Collection<Category> findAll() throws DataAccessException;

    void delete(Long id) throws DataAccessException;

}
