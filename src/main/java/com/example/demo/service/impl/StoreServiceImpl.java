package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Store;
import com.example.demo.service.StoreService;
import com.example.demo.mapper.StoreMapper;
import org.springframework.stereotype.Service;

/**
* @author 24123
* @description 针对表【t_store(仓库表)】的数据库操作Service实现
* @createDate 2025-05-27 08:29:54
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

}




