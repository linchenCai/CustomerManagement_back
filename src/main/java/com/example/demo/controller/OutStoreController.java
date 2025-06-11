package com.example.demo.controller;

import com.example.demo.pojo.OutStore;
import com.example.demo.service.OutStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class OutStoreController {
    @Autowired
    private OutStoreService outStoreService;

    /*处理商品信息出库请求*/
    @PostMapping("/doItemOutStore")
    public Map<String,Object> doItemOutStore(@RequestBody OutStore outStore){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            outStoreService.saveOutStoreService(outStore);
            result.put("code",200);
            result.put("msg","商品出库成功.......");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理出库单分页查询请求*/
    @GetMapping("/outStoreList")
    public Map<String,Object> outStoreList(
            @RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "3") Integer pageSize){
        return outStoreService.queryOutStoreListMapper(pageNum,pageSize);
    }
    /*处理出库单确认请求*/
    @GetMapping("/updateOutStore")
    public Map<String,Object> updateOutStore(Integer id){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            OutStore os=new OutStore();
            os.setOutsId(id);
            os.setIsOut("1");
            outStoreService.updateById(os);
            result.put("code",200);
            result.put("msg","出库单确认成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

}