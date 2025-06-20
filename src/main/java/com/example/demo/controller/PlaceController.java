package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Place;
import com.example.demo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class PlaceController {

    @Autowired
    private PlaceService placeService;
    /*处理加载商品产地列表的请求*/
    @GetMapping("/placeList")
    public List<Place> getPlaceList() {
        QueryWrapper<Place> wrapper = new QueryWrapper<>();
        wrapper.select("place_id","place_name");
        return placeService.list(wrapper);
    }
}
