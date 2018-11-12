package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;
    @RequestMapping("/bannerAdd")
    public @ResponseBody Map<String,Object> bannerAdd(Banner banner, HttpSession session, MultipartFile iP){
        Map<String,Object> map=new HashMap<>();
        try {
            String realPath = session.getServletContext().getRealPath("/back/banner/img");
            iP.transferTo(new File(realPath,iP.getOriginalFilename()));
            banner.setImgPath("/back/banner/img/"+iP.getOriginalFilename());
            bannerService.add(banner);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/bannerRemove")
    public @ResponseBody Map<String,Object> bannerRemove(Banner banner){
        Map<String,Object> map=new HashMap<>();
        try {

            bannerService.remove(banner);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/bannerModify")
    public @ResponseBody Map<String,Object> bannerModify(Banner banner){
        System.out.println("================");
        System.out.println(banner.getId());
        Map<String,Object> map=new HashMap<>();
        try {

            bannerService.modifyById(banner);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/bannerQuery")
    public @ResponseBody Map<String,Object> bannerQuery(){
        Map<String,Object> map=new HashMap<>();
        try {

            bannerService.findAll();
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/bannerPaging")
    public @ResponseBody Map<String,Object> bannerPaging(Integer page, Integer rows){

        System.out.println("这是轮播图！");
        Map<String,Object> map=new HashMap<>();
        List<Banner> paging = bannerService.findPaging(page, rows);
        long totals = bannerService.findTotals();
        map.put("total",totals);
        map.put("rows",paging);

        return map;
    }
    @RequestMapping("/bannerP")
    public @ResponseBody Map<String,Object> bannerP(String[] id){
        Map<String,Object> map=new HashMap<>();
        System.out.println(id);
        Banner banner=new Banner();
        try {
            for (String s : id) {
                banner.setId(s);
                bannerService.remove(banner);
            }
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
}
