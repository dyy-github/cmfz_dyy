package com.baizhi.controller;


import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
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
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;
    @RequestMapping("/guruAdd")
    public @ResponseBody Map<String,Object> guruAdd(Guru guru, MultipartFile hP, HttpSession session){
        Map<String,Object> map=new HashMap<>();
        try {
            System.out.println("-----------");
            /*获取原文件名*/
            System.out.println(hP.getOriginalFilename());
            /*获取上传路径 绝对路径      相对路径 files*/
            String realPath = session.getServletContext().getRealPath("/back/guru/img");
            System.out.println(realPath);
            /*上传*/
            hP.transferTo(new File(realPath,hP.getOriginalFilename()));
            guru.setHeadPic("/back/guru/img/"+hP.getOriginalFilename());
            System.out.println(guru.getHeadPic());
            System.out.println(guru);
            guruService.add(guru);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/guruPaging")
    public @ResponseBody Map<String,Object> guruPaging(Integer page,Integer rows){
        System.out.println("这是上师！");
        Map<String,Object> map=new HashMap<>();
        List<Guru> paging = guruService.findPaging(page, rows);
        long totals = guruService.findTotals();
        map.put("total",totals);
        map.put("rows",paging);
        //System.out.println(paging);
        return map;
    }
    @RequestMapping("/guruRemove")
    public @ResponseBody Map<String,Object> guruRemove(Guru guru){
        Map<String,Object> map=new HashMap<>();
        try {
            guruService.remove(guru);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/guruModify")
    public @ResponseBody Map<String,Object> guruModify(Guru guru,HttpSession session,MultipartFile u){
        System.out.println(guru);
        Map<String,Object> map=new HashMap<>();
        try {
            System.out.println("-----------");
            /*获取原文件名*/
            System.out.println(u.getOriginalFilename());
            /*获取上传路径 绝对路径      相对路径 files*/
            String realPath = session.getServletContext().getRealPath("/back/guru/img");
            System.out.println(realPath);
            /*上传*/
            u.transferTo(new File(realPath,u.getOriginalFilename()));
            guru.setHeadPic("/back/guru/img/"+u.getOriginalFilename());
            guruService.modifyById(guru);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("guruP")
    public @ResponseBody Map<String,Object> guruP(String[] id){
        Map<String,Object> map=new HashMap<>();
        System.out.println(id);
        Guru guru=new Guru();
        try {
            for (String s : id) {
                guru.setId(s);
                guruService.remove(guru);
            }
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
}
