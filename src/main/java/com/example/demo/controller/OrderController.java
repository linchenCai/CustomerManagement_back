package com.example.demo.controller;


import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;


    /*处理分页查询请求*/
    //    @GetMapping("/listOrder")
    @PostMapping("/listOrder")
    /* public Map<String,Object> listOrders(
           @RequestParam(defaultValue = "1")Integer pageNum
            , @RequestParam(defaultValue = "3") Integer pageSize){*/
    public Map<String,Object> listOrders(
                    @RequestBody Order order
            ){return orderService.queryOrderListService(order.getPageNum(),order.getPageSize(),order);}

    /*处理加载销售数据年份请求*/
    @GetMapping("/queryYear")
    public List<Map<String, Object>> queryYear(){
        return orderService.querySellYearService();
    }

    /*处理某年12个月销售额的请求*/
    @GetMapping("/countSell")
    public Map<String,Object> countYearSell(String year){
        return orderService.queryYearMonthService(year);
    }
    /*处理年12个月，每个月销售数量统计的请求*/
    @GetMapping("/countNum")
    public Map<String,Object> countNum(String year){
        return orderService.querySellNumService(year);
    }
}
