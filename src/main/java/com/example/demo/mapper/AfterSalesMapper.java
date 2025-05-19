package com.example.demo.mapper;

import com.example.demo.pojo.AfterSales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_after_sales】的数据库操作Mapper
* @createDate 2025-05-13 09:08:28
* @Entity com.example.demo.pojo.AfterSales
*/
public interface AfterSalesMapper extends BaseMapper<AfterSales> {
/*实现售后数据多条件分页查询*/
    public List<AfterSales> queryAfterSaleMapper(AfterSales afterSales);
}




