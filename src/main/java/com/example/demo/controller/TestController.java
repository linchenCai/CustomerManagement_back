package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@CrossOrigin
public class TestController {

    /*处理年度12个月销售数据统计的请求*/
    @GetMapping("/countSell")
    public Map<String,Object> countSell(){

        //x轴
        List<String> month=new ArrayList<>();

        //y轴
        List<Integer> sdata=new ArrayList<>();
        for(int x=1;x<=12;x++){
            sdata.add(ThreadLocalRandom.current().nextInt(500,10000));
            month.add(x+"月");
        }

        //创建Map集合
        Map<String,Object> result=new HashMap<>();
        result.put("xdata",month);
        result.put("ydata",sdata);
        return result;
    }
}