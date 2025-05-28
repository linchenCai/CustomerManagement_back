package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
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
    private Date itemDate;

    /**
     * 
     */
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
}