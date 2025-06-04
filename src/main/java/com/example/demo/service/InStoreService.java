package com.example.demo.service;

import com.example.demo.pojo.BuyList;
import com.example.demo.pojo.InStore;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 24123
* @description 针对表【t_in_store(入库单)】的数据库操作Service
* @createDate 2025-05-30 11:11:12
*/
public interface InStoreService extends IService<InStore> {
    /*实现采购采购信息入库*/
    public void saveBuyOrderInStoreService(BuyList buyList);
    /*实现入库单列表分页查询*/
    public Map<String,Object> queryInStoreListService(Integer pageNum, Integer pageSize);
}
