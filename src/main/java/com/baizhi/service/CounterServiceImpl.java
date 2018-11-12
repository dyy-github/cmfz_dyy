package com.baizhi.service;

import com.baizhi.dao.CounterDao;
import com.baizhi.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CounterServiceImpl implements CounterService {
    @Autowired
    private CounterDao counterDao;
    @Override
    public void add(Counter counter) {
        counter.setId(UUID.randomUUID().toString());
        counterDao.insert(counter);
    }

    @Override
    public void remove(Counter counter) {
        counterDao.deleteById(counter);
    }

    @Override
    public void modifyById(Counter counter) {
        counterDao.update(counter);
    }

    @Override
    public Counter findById(Counter counter) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Counter> findAll() {
        List<Counter> counters = counterDao.queryAll();
        return counters;
    }

    @Override
    public List<Counter> findPaging(Integer page, Integer rows) {
        return null;
    }

    @Override
    public long findTotals() {
        return 0;
    }
}
