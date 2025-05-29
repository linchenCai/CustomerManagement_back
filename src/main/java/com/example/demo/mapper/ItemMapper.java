package com.example.demo.mapper;

import com.example.demo.pojo.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.vo.ItemCond;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_item】的数据库操作Mapper
* @createDate 2025-05-27 15:51:59
* @Entity com.example.demo.pojo.Item
*/
public interface ItemMapper extends BaseMapper<Item> {

    /*实现商品信息分页查询*/
    /*public List<Item> queryItemListMapper();*/
    public List<Item> queryItemListMapper(ItemCond itemCond);
}




