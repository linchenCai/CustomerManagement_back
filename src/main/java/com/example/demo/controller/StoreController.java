package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Store;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class StoreController {
    @Autowired
    private StoreService storeService;
    /* 处理加载仓库列表的请求 */
    @GetMapping("/storeList") // 定义获取仓库列表的端点
    public List<Store> queryStoreList() {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.select("store_id", "store_name");
        return storeService.list(wrapper);
}
    /*处理仓库数据分页查询请求*/
    @GetMapping("/storePageList")
    public Map<String,Object> queryStoreList(
            @RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "3") Integer pageSize){
        Page <Store> page = new Page<>(pageNum,pageSize);
        List <Store> storeList = storeService.list(page);
        Map<String,Object> result=new HashMap<>();
        result.put("total",page.getTotal());
        result.put("storeList",storeList);
        return result;
    }
    /*处理添加仓库请求*/
    @PostMapping("/saveStore")
    public Map<String,Object> saveStore(@RequestBody Store store){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            storeService.save(store);
            result.put("code",200);
            result.put("msg","保存仓库信息成功......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理仓库信息更新的请求*/
    @PostMapping("/updateStore")
    public Map<String,Object> updateStore(@RequestBody Store store){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            storeService.updateById(store);
            result.put("code",200);
            result.put("msg","更新仓库信息成功......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理删除仓库请求*/
    @DeleteMapping("/deleteStore/{storeId}")
    public Map<String, Object> deleteStore(@PathVariable Integer storeId) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "删除操作失败");
        try {
            boolean success = storeService.removeById(storeId);
            if (success) {
                result.put("code", 200);
                result.put("msg", "删除仓库信息成功");
            } else {
                result.put("msg", "删除失败，仓库可能不存在");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("msg", "删除仓库信息异常: " + ex.getMessage());
        }
        return result;
    }
}
