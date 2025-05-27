package com.example.demo.controller;
import com.example.demo.pojo.Categrory;
import com.example.demo.service.CategroryService;
import com.example.demo.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategroryService categroryService;

    /*处理加载商品类目树请求*/
    @GetMapping("/categoryList")
    public List<TreeVo> categoryList(){
        return categroryService.queryCategoryListService();
    }

    /*处理商品类目添加请求*/
    @PostMapping("/saveCategory")
    public Map<String,Object> saveCategory(@RequestBody Categrory categrory){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            categroryService.save(categrory);
            result.put("code",200);
            result.put("msg","保存商品类目成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;

    }
    /*处理商品分类回显的请求*/
    @GetMapping("/loadCategory/{id}")
    public Categrory loadCategory(@PathVariable Integer id){
        return categroryService.getById(id);
    }

    /*处理商品类目更新更新请求*/
    @PostMapping("/updateCategory")
    public Map<String,Object> updateCategory(@RequestBody Categrory categrory){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            categroryService.updateById(categrory);
            result.put("code",200);
            result.put("msg","更新商品类目成功........");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
   //*处理商品类目删除的请求*//*
    @GetMapping("/deleteCategory/{id}")
    public Map<String,Object> deleteCategory(@PathVariable Integer id){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            categroryService.removeById(id);
            result.put("code",200);
            result.put("msg","删除商品类目成功........");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
