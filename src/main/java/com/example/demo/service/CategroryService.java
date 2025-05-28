package com.example.demo.service;

import com.example.demo.pojo.Categrory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.vo.TreeVo;

import java.util.List;

/**
* @author 24123
* @description 针对表【t_categrory】的数据库操作Service
* @createDate 2025-05-26 09:34:46
*/
public interface CategroryService extends IService<Categrory> {
/*加载商品类目树*/
    public List<TreeVo> queryCategoryListService();
}
