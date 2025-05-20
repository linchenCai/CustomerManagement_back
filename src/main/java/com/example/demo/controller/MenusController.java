package com.example.demo.controller;

import com.example.demo.pojo.Menus;
import com.example.demo.service.MenusService;
import com.example.demo.vo.MenusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenusController {

    @Autowired
    private MenusService menusService;

    /*定义方法处理，加载左侧菜单节点的请求*/
    @CrossOrigin
    @RequestMapping("/listMenus")
    public List<MenusVo> listMenus(){
        return menusService.queryMenuListService();
    }
    /*定义方法处理，加载左侧菜单节点的对应的组件下标的请求*/
    @CrossOrigin
    @RequestMapping("/compIndex")
    public Integer compIndex(Integer id){
        Menus menus = menusService.getById(id);
        return menus.getComponent();
    }
    /*处理菜单节点信息的添加请求*/
    @CrossOrigin
    @PostMapping("/saveMenus")
    public Map<String,Object> saveMenus(@RequestBody Menus menus){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","菜单信息添加失败.....");
        try {
            menusService.saveMenusService(menus);
            result.put("code",200);
            result.put("msg","菜单信息添加成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理菜单节点删除的请求*/
    @CrossOrigin
    @DeleteMapping("/deleteMenus/{id}")
    public Map<String,Object> deleteMenus(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","菜单信息删除失败.....");
        try {
            menusService.removeById(id);
            result.put("code",200);
            result.put("msg","菜单信息删除成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理菜单节点更新的请求*/
    @CrossOrigin
    @PostMapping("/updateMenus")
    public Map<String,Object> updateMenus(@RequestBody Menus menus){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            menusService.updateById(menus);
            result.put("code",200);
            result.put("msg","更新菜单节点成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

}