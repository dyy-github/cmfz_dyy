package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Course {//功课类
    private String id;
    private String title;
    private String marking;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creatTime;//创建时间
    private List<Counter> counters;
    public Course() {
    }

    public Course(String id, String title, String marking, Date creatTime, List<Counter> counters) {
        this.id = id;
        this.title = title;
        this.marking = marking;
        this.creatTime = creatTime;
        this.counters = counters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", marking='" + marking + '\'' +
                ", creatTime=" + creatTime +
                ", counters=" + counters +
                '}';
    }
}
