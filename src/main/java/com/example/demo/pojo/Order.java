package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName t_order
 */
@TableName(value ="t_order")
@Data
public class Order  implements Serializable {
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
    private Integer itemId;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    /**
     * 
     */
    private String state;

    /**
     * 
     */
    private String pay;

    /**
     * 
     */
    private Double payMoney;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Integer num;
    private String custName;
    @TableField(exist = false)
    private String itemName;
    @TableField(exist = false)
    private Integer pageNum=1;
    @TableField(exist = false)
    private Integer pageSize=3;
}