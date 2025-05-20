package com.example.demo.service;

import com.example.demo.mapper.MenusMapper;
import com.example.demo.pojo.Menus;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.vo.MenusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
* @author 24123
* @description 针对表【t_menus】的数据库操作Service
* @createDate 2025-05-13 14:33:12
*/
public interface MenusService extends IService<Menus> {
    /**
     * 查询并构建菜单树列表
     * @return 菜单树结构的Vo列表
     */
    List<MenusVo> queryMenuListService();
    /*添加菜单节点*/
    public void saveMenusService(Menus menus);
}
