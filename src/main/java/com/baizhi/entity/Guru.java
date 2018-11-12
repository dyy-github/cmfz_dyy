package com.baizhi.entity;

import java.util.List;

public class Guru {//上师表
    private String id;
    private String name;
    private String headPic;//头像
    private String gender;//性别
    private List<Article> articles;

    public Guru() {
    }

    public Guru(String id, String name, String headPic, String gender, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.headPic = headPic;
        this.gender = gender;
        this.articles = articles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", headPic='" + headPic + '\'' +
                ", gender='" + gender + '\'' +
                ", articles=" + articles +
                '}';
    }
}
