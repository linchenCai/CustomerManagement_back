package com.example.demo.controller;

import com.example.demo.pojo.BuyList;
import com.example.demo.service.InStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class InStoreController {
    @Autowired
    private InStoreService inStoreService;

    /*处理采购单入库请求*/
    @PostMapping("/buyInStore")
    public Map<String,Object> buyInStore(@RequestBody BuyList buyList){
        Map<String,Object> result=new HashMap<>();
        result.put("code","操作失败......");
        result.put("code",400);
        try{
            inStoreService.saveBuyOrderInStoreService(buyList);
            result.put("code",200);
            result.put("msg","采购单入库成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}