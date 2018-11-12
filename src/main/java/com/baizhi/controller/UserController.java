package com.baizhi.controller;


import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("userAdd")
    public @ResponseBody Map<String,Object> userAdd(User user){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            userService.add(user);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/userUpdate")
    public @ResponseBody Map<String,Object> userUpdate(User user){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            userService.modifyById(user);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/userSelect")
    public @ResponseBody Map<String,Object> userSelect(User user){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            User byId = userService.findById(user);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("userRemove")
    public @ResponseBody Map<String,Object> userRemove(User user){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            userService.remove(user);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
}
