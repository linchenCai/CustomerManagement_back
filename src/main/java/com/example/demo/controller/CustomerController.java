package com.example.demo.controller;

import com.example.demo.dto.CountResult;
import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

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
            @RequestParam(defaultValue = "6") Integer pageSize
    ) {
        return customerService.queryCustListService(pageNum, pageSize);
}
    /*添加方法处理客户信息修改请求*/
    @PostMapping("/updateCust")
    public Map<String,Object> updateCustomer(@RequestBody Customer customer){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.....");
        try {
            customerService.updateById(customer);
            result.put("code",200);
            result.put("msg","客户信息修改成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    /*处理客户信息删除的ajax请求*/
    @GetMapping("/delCust")
    public Map<String,Object> delCust(Integer id){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.....");
        try {
            customerService.removeById(id);
            result.put("code",200);
            result.put("msg","客户信息修改成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理加载所有客户列表请求*/
    @GetMapping("/listAllCust")
    public List<Customer> listAllCust(){
        return customerService.queryCustIdNameListService();
    }

    /*处理客户地区分布统计请求*/
    @GetMapping("/countCust")
    public List<CountResult> countCust(){

        return customerService.countCustService();
    }
}
