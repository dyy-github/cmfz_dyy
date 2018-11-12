package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//章节
public class Chapter {
    private String id;
    private String title;
    private String size;
    private String duration;//时长
    private String downPath;//下载路径
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date uploadTime;//时间
    private String w_id;

    public Chapter() {
    }

    public Chapter(String id, String title, String size, String duration, String downPath, Date uploadTime, String w_id) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.downPath = downPath;
        this.uploadTime = uploadTime;
        this.w_id = w_id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getW_id() {
        return w_id;
    }

    public void setW_id(String w_id) {
        this.w_id = w_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", downPath='" + downPath + '\'' +
                ", uploadTime=" + uploadTime +
                ", w_id='" + w_id + '\'' +
                '}';
    }
}
