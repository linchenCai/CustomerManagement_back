package com.example.demo.mapper;

import com.example.demo.pojo.InStore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_in_store(入库单)】的数据库操作Mapper
* @createDate 2025-05-30 11:11:12
* @Entity com.example.demo.pojo.InStore
*/
public interface InStoreMapper extends BaseMapper<InStore> {
    /*完成入库单列表分页查询*/
    public List<InStore> queryInStoreListMapper();
}




