package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.UserRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 24123
* @description 针对表【t_user_role】的数据库操作Service实现
* @createDate 2025-05-19 15:05:50
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




