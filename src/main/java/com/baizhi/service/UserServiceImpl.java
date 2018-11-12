package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.insert(user);
    }

    @Override
    public void remove(User user) {
        userDao.deleteById(user);

    }

    @Override
    public void modifyById(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findById(User user) {
        User user1 = userDao.queryById(user);
        return user1;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findPaging(Integer page, Integer rows) {
        Integer start=(page-1)*rows;
        List<User> users = userDao.queryPaging(start, rows);
        return users;
    }

    @Override
    public long findTotals() {
        return userDao.queryTotals();
    }
}
