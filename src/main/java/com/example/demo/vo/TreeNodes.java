package com.example.demo.vo;


import lombok.Data;

import java.util.List;

/*将数据封装为前端需要的格式*/
@Data
public class TreeNodes {

    private Integer id;
    private String name;
    private List<TreeNodes> zones;
}
