package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import com.example.demo.mapper.ItemMapper;
import org.springframework.stereotype.Service;

/**
* @author 24123
* @description 针对表【t_item】的数据库操作Service实现
* @createDate 2025-05-13 09:08:28
*/
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item>
    implements ItemService{

}




