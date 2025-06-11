package com.example.demo.controller;
import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import com.example.demo.util.CodeUtils;
import com.example.demo.vo.ItemCond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

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

    /*处理商品信息份额查询请求*/
/*    @GetMapping("/itemList")
    public Map<String,Object> itemList(@RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "3") Integer pageSize){
        return itemService.queryItemListService(pageNum,pageSize);
    }*/
    @PostMapping("/itemList")
    public Map<String,Object> itemList(@RequestBody ItemCond itemCond){
        return itemService.queryItemListService(itemCond);
    }
    /*处理商量的下架请求*/
    @GetMapping("/downItem/{id}")
    public Map<String,Object> downItem(@PathVariable Integer id){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            Item item =new Item();
            item.setId(id);
            item.setStatue(1);
            itemService.updateById(item);
            result.put("code",200);
            result.put("msg","商品下架成功........");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理商量的删除请求*/
    @GetMapping ("/DelItem/{id}")
    public Map<String,Object> DelItem(@PathVariable Integer id){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{

            itemService.removeById(id);
            result.put("code",200);
            result.put("msg","商品删除成功........");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理商品信息更新的请求*/
    @PostMapping("/updateItem")
    public Map<String,Object> updateItem(@RequestBody Item item){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            item.setStatue(0);
            itemService.updateById(item);
            result.put("code",200);
            result.put("msg","更新商品信息成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return result;
    }
}