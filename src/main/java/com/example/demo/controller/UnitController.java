package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Unit;
import com.example.demo.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UnitController {
    @Autowired
    private UnitService unitService;

    /*处理加载商品单位的列表*/
    @GetMapping("/unitList")
    public List<Unit> queryUnitList(){

        QueryWrapper<Unit> wrapper=new QueryWrapper<>();
        wrapper.select("unit_id","unit_name");
        // 在这里添加打印语句
        System.out.println("Current QueryWrapper state: " + wrapper);
        return unitService.list(wrapper);
    }
}
