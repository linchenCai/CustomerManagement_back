package com.example.demo.service;

import com.example.demo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 24123
* @description 针对表【t_user】的数据库操作Service
* @createDate 2025-05-19 15:05:50
*/
public interface UserService extends IService<User> {

    /*实现用户信息分页查询*/
    public Map<String,Object> queryUserListService(Integer pageNum, Integer pageSize);
    /*实现用户信息保存*/
    public void saveUserRolerService(User user);
    /*更新用户信息*/
    public void updateUserRolerService(User user);
    /*实现用户信息的删除*/
    public void deleteUserRoleService(Integer id);
}

