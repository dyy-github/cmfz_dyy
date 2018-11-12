package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDao guruDao;
    @Override
    public void add(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }

    @Override
    public void remove(Guru guru) {
        guruDao.deleteById(guru);
    }

    @Override
    public void modifyById(Guru guru) {
        guruDao.update(guru);
    }

    @Override
    public Guru findById(Guru guru) {
        return null;
    }

    @Override
    public List<Guru> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findPaging(Integer page, Integer rows) {
        Integer start=(page-1)*rows;
        List<Guru> gurus = guruDao.queryPaging(start, rows);
        return gurus;
    }

    @Override
    public long findTotals() {
        return guruDao.queryTotals();
    }
}
