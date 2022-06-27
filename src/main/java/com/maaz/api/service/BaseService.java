package com.maaz.api.service;

import java.util.List;

/**
 * Base Service
 * @param <T>
 */
public interface BaseService<T> {
    boolean create(T t);
    boolean update(T t);
    T findByUUid(String uuid);
    List<T> findAll();
    boolean delete(String uuid);

    //end
}
