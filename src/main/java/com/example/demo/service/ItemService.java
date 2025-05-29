package com.example.demo.service;

import com.example.demo.pojo.Item;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.vo.ItemCond;

import java.util.Map;

/**
* @author 24123
* @description 针对表【t_item】的数据库操作Service
* @createDate 2025-05-27 15:51:59
*/
public interface ItemService extends IService<Item> {
    /*实现商品信息分页查询*/
//    public Map<String,Object> queryItemListService(Integer pageNum, Integer pageSize);
    public Map<String,Object> queryItemListService(ItemCond itemCond);
}
