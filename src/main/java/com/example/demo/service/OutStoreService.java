package com.example.demo.service;

import com.example.demo.pojo.OutStore;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 24123
* @description 针对表【t_out_store(出库单)】的数据库操作Service
* @createDate 2025-06-03 14:20:01
*/
public interface OutStoreService extends IService<OutStore> {
    /*实现商品出库*/
    public void saveOutStoreService(OutStore outStore);

    /*实现入库单列表分页查询*/
    public Map<String,Object> queryOutStoreListMapper(Integer pageNum, Integer pageSize);
}
