package com.example.demo.service;

import com.example.demo.pojo.Roler;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 24123
* @description 针对表【t_roler】的数据库操作Service
* @createDate 2025-05-19 15:05:50
*/
public interface RolerService extends IService<Roler> {
    /*实现角色信息分页查询*/
    public Map<String,Object> queryRolePageListService(Integer pageNum, Integer pageSize);
}
