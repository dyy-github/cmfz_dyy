package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    /*轮播图添加*/
    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerDao.insert(banner);
    }
    /*轮播图删除*/
    @Override
    public void remove(Banner banner) {
        bannerDao.deleteById(banner);
    }
    /*轮播图修改*/
    @Override
    public void modifyById(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public Banner findById(Banner banner) {
        return null;
    }
    /*轮播图查询所有*/
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findAll() {
        return bannerDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findPaging(Integer page, Integer rows) {
        Integer start=(page-1)*rows;
        List<Banner> banners = bannerDao.queryPaging(start, rows);
        return banners;
    }

    @Override
    public long findTotals() {
        return bannerDao.queryTotals();
    }
}
