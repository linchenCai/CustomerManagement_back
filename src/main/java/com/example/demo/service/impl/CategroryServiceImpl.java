package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Categrory;
import com.example.demo.service.CategroryService;
import com.example.demo.mapper.CategroryMapper;
import com.example.demo.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 24123
* @description 针对表【t_categrory】的数据库操作Service实现
* @createDate 2025-05-26 09:34:46
*/
@Service
public class CategroryServiceImpl extends ServiceImpl<CategroryMapper, Categrory>
    implements CategroryService{
    @Autowired
    private CategroryMapper categroryMapper;
    @Override
    public List<TreeVo> queryCategoryListService() {
        /*查询数据库获得所有商品类目*/
        List<Categrory> categrories=categroryMapper.selectList(null);
        return toListTreeVo(categrories,0);
    }
    //声明方法，递归遍历categrories集合，将该集合转化为List<TreeVo>
    private List<TreeVo> toListTreeVo(List<Categrory> categrories, Integer parentId) {
        List<TreeVo> result = new ArrayList<>();
        for (Categrory categrory : categrories) {
            // 检查当前分类的父ID是否等于传入的父ID
            if (categrory.getPid() != null && categrory.getPid().equals(parentId)) {
                TreeVo treeVo = new TreeVo();
                // treeVo对象属性赋值
                treeVo.setId(categrory.getId());
                treeVo.setLabel(categrory.getCateName());
                // 避免自身循环引用
                if (!categrory.getId().equals(parentId)) {
                    treeVo.setChildren(toListTreeVo(categrories, categrory.getId()));
                }
                result.add(treeVo);
            }
        }
        return result;
    }
}