package com.example.demo.controller;

import com.example.demo.pojo.Customer;
import com.example.demo.pojo.SellJh;
import com.example.demo.service.CustomerService;
import com.example.demo.service.SellJhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class SellJhController {
    //注入Service
    @Autowired
    private SellJhService sellJhService;

    /* 处理客户信息添加请求 */
    @PostMapping("/saveSell")
    public Map<String, Object> saveCustomer(@RequestBody SellJh selljh) {//因为是json，所以要加@RequestBody
        System.out.println(selljh);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "操作失败");
        try {
            sellJhService.save(selljh);
            result.put("code", 200);
            result.put("msg", "录入成功");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }
}
