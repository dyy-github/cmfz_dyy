package com.baizhi.controller;


import com.baizhi.entity.Course;
import com.baizhi.entity.Guru;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courseAdd")
    public @ResponseBody Map<String,Object> courseAdd(Course course){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            courseService.add(course);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("courseSelect")
    public @ResponseBody Map<String,Object> courseSelect(){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            List<Course> all = courseService.findAll();
            map.put("course",all);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("courseModify")
    public @ResponseBody Map<String,Object> courseUpdate(Course course){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            courseService.modifyById(course);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/courseAll")
    public @ResponseBody Map<String,Object> courseAll(){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            List<Course> all = courseService.findAll();
            System.out.println(all);
            map.put("course",all);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/courseP")
    public @ResponseBody Map<String,Object> courseP(String[] id){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        Course course=new Course();

        try {

            for (String s : id) {
               course.setId(s);
               courseService.remove(course);
            }

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/coursePaging")
    public @ResponseBody Map<String,Object> coursePaging(Integer page,Integer rows){
        System.out.println("这是上师！");
        Map<String,Object> map=new HashMap<>();
        List<Course> paging = courseService.findPaging(page, rows);
        long totals = courseService.findTotals();
        map.put("total",totals);
        map.put("rows",paging);
        //System.out.println(paging);
        return map;
    }
}
