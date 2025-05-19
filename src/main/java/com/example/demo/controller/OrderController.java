package com.example.demo.controller;


import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
