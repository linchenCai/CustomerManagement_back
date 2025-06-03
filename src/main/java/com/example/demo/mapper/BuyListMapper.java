package com.example.demo.mapper;

import com.example.demo.pojo.BuyList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 24123
* @description 针对表【buy_list(采购单)】的数据库操作Mapper
* @createDate 2025-05-29 14:01:18
* @Entity com.example.demo.pojo.BuyList
*/
public interface BuyListMapper extends BaseMapper<BuyList> {
/*实现采购单列表分页查询*/
    public List<BuyList> queryBuyListMapper();
}




