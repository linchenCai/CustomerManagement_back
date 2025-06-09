package com.example.demo.service;

import com.example.demo.dto.CountResult;
import com.example.demo.pojo.AfterSales;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 24123
* @description 针对表【t_after_sales】的数据库操作Service
* @createDate 2025-05-13 09:08:28
*/
public interface AfterSalesService extends IService<AfterSales> {

    /*实现客户投诉信息分页查询*/
    public Map<String,Object>queryAfterSaleListService(AfterSales afterSales);
    /*实现投诉按照类型统计*/
    public List<CountResult>countQuestionTypeService();

    /*实现投诉按照处理状态统计*/
    public List<CountResult> countQuestionStateService();
}
