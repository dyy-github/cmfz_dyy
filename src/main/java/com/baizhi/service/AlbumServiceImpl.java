package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDao.insert(album);
    }

    @Override
    public void remove(Album album) {
        albumDao.deleteById(album);
    }

    @Override
    public void modifyById(Album album) {
        albumDao.update(album);
    }

    @Override
    public Album findById(Album album) {
        return null;
    }

    @Override
    public List<Album> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findPaging(Integer page, Integer rows) {
        Integer start=(page-1)*rows;
        List<Album> albums = albumDao.queryPaging(start, rows);
        return albums;
    }

    @Override
    public long findTotals() {
        return albumDao.queryTotals();
    }
}
