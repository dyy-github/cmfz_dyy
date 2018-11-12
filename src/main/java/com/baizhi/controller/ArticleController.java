package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController  {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articleAdd")
    public @ResponseBody Map<String,Object> articleAdd(Article article){
        Map<String,Object> map=new HashMap<>();
        try {
            articleService.add(article);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/articleRemove")
    public @ResponseBody Map<String,Object> articleRemove(Article article){
        Map<String,Object> map=new HashMap<>();
        try {
            articleService.remove(article);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/articleModify")
    public @ResponseBody Map<String,Object> articleModify(Article article){
        Map<String,Object> map=new HashMap<>();
        try {
            articleService.modifyById(article);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/articlePaging")
    public @ResponseBody Map<String,Object> articlePaging(Integer page, Integer rows){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        List<Article> paging = articleService.findPaging(page, rows);
        System.out.println(paging);
        long totals = articleService.findTotals();
        map.put("total",totals);
        map.put("rows",paging);
        System.out.println(map);
        return map;
    }
    @RequestMapping("/articleP")
    public @ResponseBody Map<String,Object> articleP(String[] id){
        Map<String,Object> map=new HashMap<>();
        Article article=new Article();
        try {
            for (String s : id) {
                article.setId(s);
                articleService.remove(article);
            }
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
}
