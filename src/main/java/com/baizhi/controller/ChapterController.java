package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/chapterAdd")
    public @ResponseBody Map<String,Object> chapterAdd(Chapter chapter, HttpSession session, MultipartFile dP){
        System.out.println(chapter);
        Map<String,Object> map=new HashMap<>();
        try {
            String realPath = session.getServletContext().getRealPath("/back/chapter/audio");
            dP.transferTo(new File(realPath,dP.getOriginalFilename()));
            chapter.setDownPath("/back/chapter/audio/"+dP.getOriginalFilename());
            chapterService.add(chapter);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/chapterRemove")
    public @ResponseBody Map<String,Object> chapterRemove(Chapter chapter){
        System.out.println(chapter.getId());
        Map<String,Object> map=new HashMap<>();
        try {
            chapterService.remove(chapter);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/chapterModify")
    public @ResponseBody Map<String,Object> chapterModify(Chapter chapter){
        Map<String,Object> map=new HashMap<>();
        try {
            chapterService.modifyById(chapter);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/downLoad")
    public void downLoad(String fileName,HttpSession session,HttpServletResponse response) throws IOException {
        System.out.println(fileName);

        String[] split = fileName.split("/");
        String filename=split[split.length-1];

        //获取绝对路径
        String realPath = session.getServletContext().getRealPath("/back/chapter/audio");
        //以文件输入流读取文件
        FileInputStream fileInputStream=new FileInputStream(new File(realPath,filename));
        //获取响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //设置下载格式
        response.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(fileName,"UTF-8"));
        //使用IOUtils工具类
        IOUtils.copy(fileInputStream,outputStream);
        //安静、优雅关流
        IOUtils.closeQuietly(fileInputStream);
        IOUtils.closeQuietly(outputStream);
        System.out.println("-------------");

    }
}
