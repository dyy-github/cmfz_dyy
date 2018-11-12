package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;
    @Override
    public void add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapterDao.insert(chapter);
    }

    @Override
    public void remove(Chapter chapter) {
        chapterDao.deleteById(chapter);
    }

    @Override
    public void modifyById(Chapter chapter) {
        chapterDao.update(chapter);
    }

    @Override
    public Chapter findById(Chapter chapter) {
        return null;
    }

    @Override
    public List<Chapter> findAll() {
        return null;
    }

    @Override
    public List<Chapter> findPaging(Integer page, Integer rows) {
        return null;
    }

    @Override
    public long findTotals() {
        return 0;
    }
}
