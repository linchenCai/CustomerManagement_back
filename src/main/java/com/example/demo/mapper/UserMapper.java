package com.example.demo.mapper;

import com.example.demo.dto.CountResult;
import com.example.demo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2025-05-19 15:05:50
* @Entity com.example.demo.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    /*保存用户信息*/
    public  void  saveUserMapper(User user);
    /*实现员工按照年龄段分布统计*/
    public List<CountResult> countEmployeeAgeMapper();
    /*实现员工按照学统计*/
    public List<CountResult> countEmployeeEduMapper();

}




