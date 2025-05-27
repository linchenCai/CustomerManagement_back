package com.example.demo.vo;

import lombok.Data;

import java.util.List;
@Data
public class TreeVo {
    private Integer id;
    private String label;
    private List<TreeVo> children;
}
