package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.SellJh;
import com.example.demo.service.SellJhService;
import com.example.demo.mapper.SellJhMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 24123
* @description 针对表【t_sell_jh】的数据库操作Service实现
* @createDate 2025-05-13 09:08:28
*/
@Service
public class SellJhServiceImpl extends ServiceImpl<SellJhMapper, SellJh>
    implements SellJhService{
    @Autowired
    private SellJhMapper sellJhMapper;
    @Override
    public Map<String, Object> querySellJhListService(Integer pageNum, Integer pageSize) {
        Map<String, Object>result=new HashMap<>();
        //Page <SellJh> page= new Page<>(pageNum, pageSize);
        Page<SellJh> page = PageHelper.startPage(pageNum, pageSize);
        System.out.println("1---------"+page.getTotal());
        //List<SellJh> sellJhs = sellJhMapper.selctList(page, null);ectList(page, null);
        List<SellJh> sellJhs = sellJhMapper.querySellJhListMapper();
        System.out.println("2---------"+page.getTotal());
        result.put("sellJhList",sellJhs);
        result.put("total",page.getTotal());
        return result;
    }

}




