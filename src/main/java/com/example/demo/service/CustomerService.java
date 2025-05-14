package com.example.demo.service;

import com.example.demo.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 24123
* @description 针对表【t_customer】的数据库操作Service
* @createDate 2025-05-13 09:08:28
*/
public interface CustomerService extends IService<Customer> {
    public Map<String, Object> queryCustListService(Integer pageNum, Integer pageSize);
    /*查询所有客户Id和姓名*/
    public List<Customer> queryCustIdNameListService();
}
