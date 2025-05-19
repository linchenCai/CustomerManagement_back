package com.example.demo.mapper;

import com.example.demo.dto.HisData;
import com.example.demo.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2025-05-13 09:08:28
* @Entity com.example.demo.pojo.Order
*/
public interface OrderMapper extends BaseMapper<Order> {
//查询统计每个用户历史消费总额
    public List<HisData>queryCountHisDataMapper();
    /*实现订单数据动态多条件分页查询
     * order:封装动态where条件
     * */
    public List<Order> queryOrderListMapper(Order order);
}




