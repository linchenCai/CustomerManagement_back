package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

/**
* @author 24123
* @description 针对表【t_customer】的数据库操作Service实现
* @createDate 2025-05-13 09:08:28
*/
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer>
    implements CustomerService{

}




