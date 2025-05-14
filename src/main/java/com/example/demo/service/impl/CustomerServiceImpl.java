package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 24123
* @description 针对表【t_customer】的数据库操作Service实现
* @createDate 2025-05-13 09:08:28
*/
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer>
    implements CustomerService{
    // 注入Mapper
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Map<String, Object> queryCustListService(Integer pageNum, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();
        // 创建封装分页查询参数的Page对象
        Page page = new Page(pageNum, pageSize);
        System.out.println(page.getTotal());
        List list = customerMapper.selectList(page, null);
        System.out.println(page.getTotal());

        result.put("custList", list);
        result.put("total", page.getTotal());
        return result;
    }
}




