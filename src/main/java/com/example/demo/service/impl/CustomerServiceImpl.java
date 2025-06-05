package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.CountResult;
import com.example.demo.dto.HisData;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private OrderMapper orderMapper;
    @Transactional
    @Override
    public Map<String, Object> queryCustListService(Integer pageNum, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();
        System.out.println("==================");
        //将客户历史消费信息更新到客户信息表
        List<HisData> hisDatas = orderMapper.queryCountHisDataMapper();

        for(HisData hisData:hisDatas){
            Customer cust=new Customer();
            cust.setId(hisData.getCustId());
            cust.setHisTotal(hisData.getHisTotal());
            customerMapper.updateById(cust);
        }
        // 创建封装分页查询参数的Page对象
        Page page = new Page(pageNum, pageSize);
        System.out.println(page.getTotal());
        List list = customerMapper.selectList(page, null);
        System.out.println(page.getTotal());

        result.put("custList", list);
        result.put("total", page.getTotal());
        return result;
    }

    @Override
    public List<Customer> queryCustIdNameListService() {
        QueryWrapper<Customer> wrapper=new QueryWrapper<>();
        //指定列的投影，指定select id,cust_name
        wrapper.select("id","cust_name");
        List<Customer> customerList = customerMapper.selectList(wrapper);
        return customerList;
    }
    @Override
    public List<CountResult> countCustService() {
        return customerMapper.countCustomerAreaMapper();
    }
}




