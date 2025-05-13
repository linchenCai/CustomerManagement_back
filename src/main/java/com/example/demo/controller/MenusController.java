package com.example.demo.controller;

import com.example.demo.pojo.Menus;
import com.example.demo.service.MenusService;
import com.example.demo.vo.MenusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
}