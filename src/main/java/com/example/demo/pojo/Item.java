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
    private String itemName;

    /**
     * 
     */
    private Double price;

    /**
     * 
     */
    private Date itemDate;

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
    private Integer store;
}