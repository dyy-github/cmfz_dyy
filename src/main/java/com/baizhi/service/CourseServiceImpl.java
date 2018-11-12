package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public void add(Course course) {
        course.setId(UUID.randomUUID().toString());
        courseDao.insert(course);
    }

    @Override
    public void remove(Course course) {
        courseDao.deleteById(course);
    }

    @Override
    public void modifyById(Course course) {
        courseDao.update(course);
    }

    @Override
    public Course findById(Course course) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findAll() {
        List<Course> courses = courseDao.queryAll();
        return courses;
    }

    @Override
    public List<Course> findPaging(Integer page, Integer rows) {
        Integer start=(page-1)*rows;
        List<Course> courses = courseDao.queryPaging(start, rows);
        return courses;
    }

    @Override
    public long findTotals() {
        return courseDao.queryTotals();
    }
}
