package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 24123
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2025-05-19 15:05:50
* @Entity com.example.demo.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    /*保存用户信息*/
    public  void  saveUserMapper(User user);
}




