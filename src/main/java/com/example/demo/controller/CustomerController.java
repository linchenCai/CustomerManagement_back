package com.example.demo.controller;

import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class CustomerController {

    //注入Service
    @Autowired
    private CustomerService customerService;

    /* 处理客户信息添加请求 */
    @PostMapping("/saveCust")
    public Map<String, Object> saveCustomer(@RequestBody Customer customer) {//因为是json，所以要加@RequestBody
        System.out.println(customer);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "操作失败");
        try {
            customerService.save(customer);
            result.put("code", 200);
            result.put("msg", "录入成功");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }
    /* 处理客户信息分页查询请求 */
    @GetMapping("/listCust")
    public Map<String, Object> queryCustList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "3") Integer pageSize
    ) {
        return customerService.queryCustListService(pageNum, pageSize);
}}
