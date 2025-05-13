package com.example.demo.vo;

import lombok.Data;

import java.util.List;
@Data
public class MenusVo {
    private Integer id;
    private String label;
    private Integer component;
    private List<MenusVo> subMenus;
}
