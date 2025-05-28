package com.example.demo.controller;
import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import com.example.demo.util.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class ItemController {

    /*处理产生商品编码的请求*/
    @GetMapping("/getCode")
    public String toItemCode(){
        return CodeUtils.toItemCode();
    }
    @Autowired
    private ItemService itemService;
    /*处理商品信息保存的请求*/
    @PostMapping("/addItem")
    public Map<String,Object> addItem(@RequestBody Item item){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            itemService.save(item);
            result.put("code",200);
            result.put("msg","添加商品信息成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return result;

    }
}