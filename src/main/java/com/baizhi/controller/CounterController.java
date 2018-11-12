package com.baizhi.controller;

import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/counter")
public class CounterController {
    @Autowired
    private CounterService counterService;

    @RequestMapping("counterAdd")
    public @ResponseBody Map<String,Object> counterAdd(Counter counter){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            counterService.add(counter);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @RequestMapping("counterRemove")
    public @ResponseBody Map<String,Object> counterRemove(Counter counter){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            counterService.remove(counter);

            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @RequestMapping("counterSelect")
    public @ResponseBody Map<String,Object> counterSelect(){
        System.out.println("-----------");
        Map<String,Object> map=new HashMap<>();
        try {

            List<Counter> all = counterService.findAll();
            map.put("counter",all);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
}
