package com.example.demo.mapper;

import com.example.demo.pojo.Roler;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_roler】的数据库操作Mapper
* @createDate 2025-05-19 15:05:50
* @Entity com.example.demo.pojo.Roler
*/
public interface RolerMapper extends BaseMapper<Roler> {
/*查询某个角色的所有菜单叶子节点id集合*/
    public List<Integer> queryRoleMidsMapper(Integer rid);

}




