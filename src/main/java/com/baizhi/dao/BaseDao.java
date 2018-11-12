package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    public void insert(T t);
    public void deleteById(T t);
    public void update(T t);
    public T queryById(T t);
    public List<T> queryAll();
    public List<T> queryPaging(@Param("start") Integer start, @Param("rows") Integer rows);
    public long queryTotals();
}
