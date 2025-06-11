package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dto.CountResult;
import com.example.demo.pojo.User;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    /*处理用户信息分页查询*/
    @GetMapping("/userList")
    public Map<String,Object> userList(
            @RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "3")Integer pageSize) {
        return userService.queryUserListService(pageNum,pageSize);
    }
    /*添加方法处理用户信息添加请求*/
    @PostMapping("/saveUser")
    public Map<String,Object> saveUser(@RequestBody User user) {
        Map<String,Object> result =new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.....");
        try{
            userService.saveUserRolerService(user);
            result.put("code",200);
            result.put("msg","用户信息添加成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  result;
    }
    @Autowired
    private UserRoleService userRoleService;
    /*根据用户id查询某个用户的所有角色id*/
    @GetMapping("/queryUserRids/{id}")
    public List<Integer>queryUserRids(@PathVariable Integer id) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("uid",id);//查询某个用户id对应的所有角色id
        wrapper.select("rid");
        List<Integer> result = userRoleService.listObjs(wrapper);
        return result;

    }
    /*处理用户信息更新请求*/
    @PostMapping("/updateUser")
    public Map<String,Object> updateUser(@RequestBody User user) {
    Map<String,Object> result =new HashMap<>();
    result.put("code",400);
    result.put("msg","操作失败.....");
    try{
        userService.updateUserRolerService(user);
        result.put("code",200);
        result.put("msg","用户信息更新成功.....");
    }catch (Exception ex){
        ex.printStackTrace();
    }
    return  result;
    }
    /*处理用户信息删除请求*/
    @GetMapping("/delUser/{id}")
    public Map<String,Object> delUser(@PathVariable Integer id) {
        Map<String,Object> result =new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.....");
        try{
            userService.deleteUserRoleService(id);
            result.put("code",200);
            result.put("msg","用户信息删除成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  result;
    }
    /*处理员工年龄分部统计请求*/
    @GetMapping("/countEmpAge")
    public List<CountResult> countEmpAge(){
        return userService.countEmployeeAgeService();
    }
    /*处理员工学历分布统计的请求*/
    @GetMapping("/countEmpEdu")
    public List<CountResult> countEmpEdu(){
        return userService.countEmployeeEduService();
    }
}
