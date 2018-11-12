package com.baizhi.entity;

import java.util.Date;

public class Counter {
    private String id;
    private String title;
    private String count;
    private Date recorDate;
    private String user_id;
    private String course_id;

    public Counter() {
    }

    public Counter(String id, String title, String count, Date recorDate, String user_id, String course_id) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.recorDate = recorDate;
        this.user_id = user_id;
        this.course_id = course_id;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Date getRecorDate() {
        return recorDate;
    }

    public void setRecorDate(Date recorDate) {
        this.recorDate = recorDate;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count='" + count + '\'' +
                ", recorDate=" + recorDate +
                ", user_id='" + user_id + '\'' +
                ", course_id='" + course_id + '\'' +
                '}';
    }
}
