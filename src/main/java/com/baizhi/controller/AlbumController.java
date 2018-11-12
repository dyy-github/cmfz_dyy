package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/albumAdd")
    public @ResponseBody Map<String,Object> albumAdd(Album album, HttpSession session, MultipartFile cI){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {
            String realPath = session.getServletContext().getRealPath("/back/album/img");
            cI.transferTo(new File(realPath,cI.getOriginalFilename()));
            album.setCoverImg("/back/album/img/"+cI.getOriginalFilename());
            albumService.add(album);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/albumPaging")
    public @ResponseBody Map<String,Object> albumPaging(Integer page, Integer rows){
        //System.out.println("=============");
        Map<String,Object> map=new HashMap<>();
        List<Album> paging = albumService.findPaging(page, rows);
        long totals = albumService.findTotals();
        map.put("total",totals);
        map.put("rows",paging);
        //System.out.println(map);

        return map;
    }
    @RequestMapping("/albumModify")
    public @ResponseBody Map<String,Object> albumModify(Album album){
        Map<String,Object> map=new HashMap<>();
        try {
            albumService.modifyById(album);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/albumRemove")
    public @ResponseBody Map<String,Object> albumRemove(Album album){
        System.out.println(album.getId());
        Map<String,Object> map=new HashMap<>();
        try {
            albumService.remove(album);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

}
