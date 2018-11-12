package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public void add(Admin admin) {
        adminDao.insert(admin);
    }

    @Override
    public void remove(Admin admin) {

    }

    @Override
    public void modifyById(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findById(Admin admin) {
        return adminDao.queryById(admin);
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public List<Admin> findPaging(Integer page, Integer rows) {
        return null;
    }

    @Override
    public long findTotals() {
        return 0;
    }
}
