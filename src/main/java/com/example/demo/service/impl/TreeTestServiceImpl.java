package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.TreeTest;
import com.example.demo.service.TreeTestService;
import com.example.demo.mapper.TreeTestMapper;
import com.example.demo.vo.TreeNodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 24123
* @description 针对表【t_tree_test】的数据库操作Service实现
* @createDate 2025-05-19 17:12:55
*/
@Service
public class TreeTestServiceImpl extends ServiceImpl<TreeTestMapper, TreeTest>
    implements TreeTestService{
    @Autowired
    private TreeTestMapper treeTestMapper;
    @Override
    public List<TreeNodes> queryTreeListService() {

        //查询数据库
        List<TreeTest> treeTestList = treeTestMapper.selectList(null);
        //将treeTestList集合转化为List<TreeNodes> 集合
        return doTreeTestList(treeTestList,0);
    }
    //递归遍历treeTestList集合，将该集合转化为前端需要格式
    private List<TreeNodes> doTreeTestList(List<TreeTest> treeTestList,Integer id ){
        List<TreeNodes> result=new ArrayList<>();
        //遍历集合
        for(TreeTest tt:treeTestList){
            if(tt.getPid().equals(id)){
                //创建TreeNode对象，封装数据
                TreeNodes treeNode=new TreeNodes();
                treeNode.setId(tt.getId());
                treeNode.setName(tt.getTname());
                //递归遍历
                treeNode.setZones(doTreeTestList(treeTestList,tt.getId()));

                result.add(treeNode);
            }
        }
        return result;
    }
}




