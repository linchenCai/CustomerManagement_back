package com.example.demo.service;

import com.example.demo.pojo.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_role_menu】的数据库操作Service
* @createDate 2025-05-19 15:05:50
*/
public interface RoleMenuService extends IService<RoleMenu> {

    /*查询某个角色所有菜单ID集合*/
    public List<Integer> queryRoleMidsListService(Integer rid);
}
