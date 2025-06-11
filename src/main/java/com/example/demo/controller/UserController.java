package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dto.CountResult;
import com.example.demo.dto.UserVo;
import com.example.demo.pojo.User;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
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
/*处理用户登录请求*/
@PostMapping("/userLogin")
public Map<String,Object> userLogin(@RequestBody UserVo user, HttpSession session){
    //初始化返回结果map
    Map<String,Object> result=new HashMap<>();
    //默认返回失败的结果
    result.put("code",400);
    result.put("msg","操作失败......");
    try{
        //根据用户名查询用户信息
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",user.getUname());
        List<User> list = userService.list(wrapper);
        //判断查询结果是否唯一
        if(list!=null && list.size()==1){
            //获得数据库查询到的用户对象
            User dbUser = list.get(0);

            //验证密码是否正确
            if(dbUser.getUpwd().equals(user.getUpwd())){
                //将当前登录用户保存到session会话中
                session.setAttribute("online",dbUser);
                //更新返回结果为成功
                result.put("code",200);
                result.put("msg","登录成功......");
            }
        }

    }
    //异常处理
    catch(Exception ex){
        ex.printStackTrace();
    }
    //返回处理结果
    return result;
}

}
