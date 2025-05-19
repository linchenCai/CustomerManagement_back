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
    private String grade;

    /**
     * 
     */
    private Integer level;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String custName;
    @TableField(exist = false)
    private Integer pageNum=1;
    @TableField(exist = false)
    private Integer pageSize=3;
}