package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName t_item
 */
@TableName(value ="t_item")
@Data
public class Item {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String itemNum;

    /**
     * 
     */
    private String itemName;

    /**
     * 
     */
    private Integer typeId;

    /**
     * 
     */
    private Integer store;

    /**
     * 
     */
    private Integer brandId;

    /**
     * 
     */
    private Integer storeId;

    /**
     * 
     */
    private Integer supplyId;

    /**
     * 
     */
    private Integer placeId;

    /**
     * 
     */
    private Integer unitId;

    /**
     * 
     */
    private Double price;

    /**
     * 
     */
    private Double sellPrice;

    /**
     * 
     */
    private Double vipPrice;

    /**
     * 
     */
    private String itemDesc;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date itemDate;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 
     */
    private String hotTitle;

    /**
     * 
     */
    private String facturer;

    /**
     * 
     */
    private Integer statue;

    /**
     * 
     */
    private String imgs;

    /**
     * 
     */
    private String createBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    //扩展属性封装名称
    @TableField(exist = false)
    private String brandName;
    @TableField(exist = false)
    private String placeName;
    @TableField(exist = false)
    private String supplyName;
    @TableField(exist = false)
    private String unitName;
    @TableField(exist = false)
    private String cateName;
    @TableField(exist = false)
    private String storeName;
}