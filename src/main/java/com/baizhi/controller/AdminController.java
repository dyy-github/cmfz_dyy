package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /*登陆功能*/
    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request,String enCode){
        HttpSession session = request.getSession();
        String validationCode = (String) session.getAttribute("validationCode");

        Admin byId = adminService.findById(admin);
        System.out.println("----------------------");
        if (validationCode.equals(enCode)){

            if(byId==null){
                return "redirect:/back/login.jsp";
            }
            session.setAttribute("admin",byId);
            return "redirect:/back/main/main.jsp";
        }
        return "redirect:/back/login.jsp";
    }
    /*退出登录*/
    @RequestMapping("/exit")
    public String exitLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "redirect:/back/login.jsp";
    }
    /*修改密码*/
    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> updatePassword(HttpServletRequest request,Admin admin){
        HttpSession session = request.getSession();
       // session.getAttribute("admin");
        Map<String,Object> map=new HashMap<>();
        System.out.println("============");
        try {
            adminService.modifyById(admin);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",e.getMessage());
        }
        return map;
    }
}
