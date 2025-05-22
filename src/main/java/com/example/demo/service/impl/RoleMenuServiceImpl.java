package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.RolerMapper;
import com.example.demo.pojo.RoleMenu;
import com.example.demo.service.RoleMenuService;
import com.example.demo.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_role_menu】的数据库操作Service实现
* @createDate 2025-05-19 15:05:50
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService{
@Autowired
private RolerMapper rolerMapper;

    @Override
    public List<Integer> queryRoleMidsListService(Integer rid) {
        return rolerMapper.queryRoleMidsMapper(rid);
    }

}




