package com.xin.repository;

import com.xin.model.User;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午9:38
 */
public interface UserRepo {

    Long save(User user) throws DataAccessException;

    User findById(Long id) throws DataAccessException;

    User findByName(String name) throws DataAccessException;

    Collection<User> findAll() throws DataAccessException;


}
