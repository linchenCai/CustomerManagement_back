package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Brand;
import com.example.demo.service.BrandService;
import com.example.demo.mapper.BrandMapper;
import org.springframework.stereotype.Service;

/**
* @author 24123
* @description 针对表【t_brand(品牌表)】的数据库操作Service实现
* @createDate 2025-05-27 08:29:54
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
    implements BrandService{

}




