package com.example.demo.service;

import com.example.demo.pojo.TreeTest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.vo.TreeNodes;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_tree_test】的数据库操作Service
* @createDate 2025-05-19 17:12:55
*/
public interface TreeTestService extends IService<TreeTest> {
    /*加载tree控件需要渲染的数据*/
    public List<TreeNodes> queryTreeListService();
}
