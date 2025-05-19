package com.example.demo.service;

import com.example.demo.pojo.Replay;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 24123
* @description 针对表【t_replay】的数据库操作Service
* @createDate 2025-05-19 08:52:51
*/
public interface ReplayService extends IService<Replay> {
    /*根据投诉id。查询投诉回复列表*/
    public Map<String,Object> queryReplayListService(Integer id
            , Integer pageNum, Integer pageSize);
}
