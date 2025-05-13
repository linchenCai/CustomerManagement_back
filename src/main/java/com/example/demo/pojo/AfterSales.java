package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName t_after_sales
 */
@TableName(value ="t_after_sales")
@Data
public class AfterSales {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer custId;

    /**
     * 
     */
    private String question;

    /**
     * 
     */
    private String state;

    /**
     * 
     */
    private String record;

    /**
     * 
     */
    private Integer level;
}