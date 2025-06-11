package com.example.demo.controller;

import com.example.demo.service.TreeTestService;
import com.example.demo.vo.TreeNodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TreeTestController {
    @Autowired
    private TreeTestService treeTestService;

    /*处理树节点加载的请求*/
    @GetMapping("/loadTree")
    public List<TreeNodes> loadTree(){
        return treeTestService.queryTreeListService();
    }
}
