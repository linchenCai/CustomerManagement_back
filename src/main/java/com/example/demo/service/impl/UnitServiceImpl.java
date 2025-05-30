package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Unit;
import com.example.demo.service.UnitService;
import com.example.demo.mapper.UnitMapper;
import org.springframework.stereotype.Service;

/**
* @author 24123
* @description 针对表【t_unit(规格单位表)】的数据库操作Service实现
* @createDate 2025-05-27 08:29:54
*/
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit>
    implements UnitService{

}




