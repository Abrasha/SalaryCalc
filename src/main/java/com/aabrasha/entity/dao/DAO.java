package com.aabrasha.entity.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable> {

    Serializable save(T obj);
    void delete(T obj);
    void update(T obj);
    T get(Serializable id);
    List<T> getAll();

}