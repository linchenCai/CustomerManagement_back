package com.example.demo.controller;

import com.example.demo.pojo.SellJh;
import com.example.demo.service.SellJhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class SellJhController {
    //注入Service
    @Autowired
    private SellJhService sellJhService;

    /* 处理客户信息添加请求 */
    @PostMapping("/saveSell")
    public Map<String, Object> saveSelljh(@RequestBody SellJh selljh) {//因为是json，所以要加@RequestBody
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
    /*处理销售过程分页查询请求*/
    @GetMapping("/sellJhList")
    public Map<String, Object> sellJhList(@RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "3") Integer pageSize) {

        return sellJhService.querySellJhListService(pageNum,pageSize);
    }
    /*处理销售过程修改请求*/
    @PostMapping("/updateSellJh")
    public Map<String, Object> updateSellJh(@RequestBody SellJh sellJh) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "操作失败...");
        try {
            sellJhService.updateById(sellJh);
            result.put("code", 200);
            result.put("msg", "更新客户销售过程数据成功...");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
/*处理客户销售信息删除请求*/
    @GetMapping("/delSellJh")
    public Map<String, Object> delSellJh(Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "操作失败...");
        try {
            sellJhService.removeById(id);
            result.put("code", 200);
            result.put("msg", "删除客户销售过程数据成功...");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

}
