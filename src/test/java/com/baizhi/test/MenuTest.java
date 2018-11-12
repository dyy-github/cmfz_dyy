package com.baizhi.test;

import com.baizhi.dao.*;
import com.baizhi.entity.*;
import com.baizhi.service.*;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MenuTest extends BasicTest {
    @Autowired
    private MenuService menuService;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminService adminService;
    @Autowired
    private BannerDao bannerDao;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private GuruDao guruDao;
    @Autowired
    private GuruService guruService;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CourseService courseService;



    @Test
    public void findAll(){
        List<Menu> all = menuService.findAll();
        for (Menu menu : all) {
            System.out.println(all);
        }
    }
    @Test
    public void findAll1(){
        List<Course> paging = courseService.findPaging(1, 3);
        System.out.println(paging);
    }
    @Test
    public void queryById(){
        Admin admin=new Admin();
        admin.setId(UUID.randomUUID().toString());
        admin.setName("tom");
        admin.setPassword("123");
        adminDao.insert(admin);
    }
    @Test
    public void update(){
        Admin admin=new Admin();
        admin.setId("7371a702-408b-42c4-ae94-1676be8611c4");

        admin.setPassword("123");
        adminService.modifyById(admin);
    }
    @Test
    public void query(){
        Admin admin=new Admin();

        admin.setName("tom");
        admin.setPassword("123");

        Admin admin1 = adminService.findById(admin);
        System.out.println(admin1);
    }
    @Test
    public void bannerD(){
        Banner banner=new Banner();
        banner.setId(UUID.randomUUID().toString());
        banner.setTitle("1.jpg");
        banner.setImgPath("/back/banner/img/1.jpg");
        banner.setDescs("1");
        banner.setStatus("禁用");
        banner.setDate(new Date());
        bannerDao.insert(banner);
    }

    @Test
    public void bannerD1(){
        Banner banner=new Banner();
        banner.setId("ae9fd102-1fcd-4e81-983a-bdc39323f897");
        banner.setTitle("3.jpg");
        banner.setImgPath("/back/banner/img/3.jpg");
        banner.setDescs("3");
        banner.setStatus("启用");
        banner.setDate(new Date());
        bannerDao.update(banner);
    }
    @Test
    public void bannerD2(){

        List<Banner> banners = bannerDao.queryAll();
        System.out.println(banners);
    }
    @Test
    public void bannerD3(){
        Banner banner=new Banner();
        banner.setId("ae9fd102-1fcd-4e81-983a-bdc39323f897");
        bannerDao.deleteById(banner);

    }
    @Test
    public void bannerD4(){

        List<Banner> all = bannerService.findAll();
        System.out.println(all);

    }
    @Test
    public void bannerD5(){

        List<Banner> all = bannerDao.queryPaging(1,3);
        for (Banner banner : all) {

            System.out.println(banner);
        }

    }
    @Test
    public void bannerD6(){

        long l = bannerService.findTotals();

        System.out.println(l);

    }
    @Test
    public void bannerD7(){

        List<Banner> paging = bannerService.findPaging(1, 3);
        for (Banner banner : paging) {
            System.out.println(banner);
        }


    }
    @Test
    public void bannerD8(){
        Album album=new Album();
        album.setId("7");
        album.setTitle("vvv");
        album.setPublishDate(new Date());
        album.setCoverImg("vvv");
        album.setCount(12);
        album.setBrief("vvv");
        album.setAuthor("vvv");
        album.setStar("vvv");
        album.setBroadCast("vvv");
        albumDao.insert(album);

    }
    @Test
    public void bannerD9(){
        List<Album> albums = albumDao.queryPaging(0, 10);
        for (Album album : albums) {
            System.out.println(album);
        }


    }
    @Test
    public void bannerD10(){
        long l = albumDao.queryTotals();
        System.out.println(l);


    }
    @Test
    public void bannerD11(){
        Album album=new Album();
        album.setId("1");
        album.setTitle("ppp");
        album.setPublishDate(new Date());
        album.setCoverImg("ppp");
        album.setCount(12);
        album.setBrief("ppp");
        album.setAuthor("ppp");
        album.setStar("ppp");
        album.setBroadCast("ppp");
        albumDao.update(album);

    }
    @Test
    public void bannerD12(){
        Album album=new Album();
        album.setId("7");
        albumDao.deleteById(album);

    }
    @Test
    public void bannerD13(){
        Chapter chapter=new Chapter();
        chapter.setId("5");
        chapter.setTitle("ee");
        chapter.setSize("ee");
        chapter.setUploadTime(new Date());
        chapter.setDownPath("ee");
        chapter.setDuration("ee");
        chapter.setW_id("5");
        chapterDao.insert(chapter);

    }
    @Test
    public void bannerD14(){

        List<Album> paging = albumService.findPaging(2, 3);
        System.out.println(paging);

    }
    @Test
    public void bannerD15(){
        Chapter chapter=new Chapter();
        chapter.setId("6");
        chapter.setTitle("gg");
        chapter.setSize("gg");
        chapter.setUploadTime(new Date());
        chapter.setDownPath("gg");
        chapter.setDuration("gg");
        chapter.setW_id("6");
        chapterService.add(chapter);

    }
    @Test
    public void bannerD16(){
        List<Guru> gurus = guruDao.queryPaging(0, 3);
        for (Guru guru : gurus) {
            System.out.println(guru);
        }

    }
    @Test
    public void bannerD17(){
        Guru guru=new Guru();
        guru.setId("4");
        guru.setName("44");
        guru.setHeadPic("44");
        guru.setGender("");
        guruDao.insert(guru);
    }
    @Test
    public void bannerD18(){
        List<Guru> paging = guruService.findPaging(1, 3);
        for (Guru guru : paging) {
            System.out.println(guru);
        }
    }
    @Test
    public void bannerD181(){
        long totals = guruService.findTotals();
        System.out.println(totals);
    }
    @Test
    public void bannerD1811(){
        Guru guru=new Guru();
        guru.setName("aa");
        guru.setHeadPic("dddddddddddddddddddddd");
        guru.setGender("true");
        guruService.add(guru);

    }
    @Test
    public void bannerD182(){
        Guru guru=new Guru();
        guru.setId("3");
        guru.setName("333");
        guru.setHeadPic("333");
        guru.setGender("true");
        guruService.modifyById(guru);
    }
    @Test
    public void bannerD19(){
        Article article=new Article();
        article.setId("1");
        article.setTitle("www");
        article.setImgPath("www");
        article.setContent("www");
        article.setPublishDate(new Date());
        articleDao.update(article);
    }
    @Test
    public void bannerD20(){
        List<Article> articles = articleDao.queryPaging(0, 3);
        for (Article article : articles) {
            System.out.println(article);
        }
    }

}
