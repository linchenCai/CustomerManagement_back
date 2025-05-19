package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String uname;

    /**
     * 
     */
    private String upwd;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String edu;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String title;
}