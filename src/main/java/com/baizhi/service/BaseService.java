package com.baizhi.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService<T> {
    public void add(T t);
    public void remove(T t);
    public void modifyById(T t);
    public T findById(T t);
    public List<T> findAll();
    public List<T> findPaging(Integer page,Integer rows);
    public long findTotals();

}
