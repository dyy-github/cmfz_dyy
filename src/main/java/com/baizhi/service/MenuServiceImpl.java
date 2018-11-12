package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public void add(Menu menu) {

    }

    @Override
    public void remove(Menu menu) {

    }

    @Override
    public void modifyById(Menu menu) {

    }

    @Override
    public Menu findById(Menu menu) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> findAll() {
        List<Menu> menus = menuDao.queryAll();
        return menus;
    }

    @Override
    public List<Menu> findPaging(Integer page, Integer rows) {
        return null;
    }

    @Override
    public long findTotals() {
        return 0;
    }
}
