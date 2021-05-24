package com.lead.model.admin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName AdUser
 * @date 2021/5/24 16:03
 * @Version 1.0
 * @Author ShyBoy
 */
@Data
@TableName("ad_user")
public class AdUser {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录用户名
     */
    @TableField("name")
    @ApiModelProperty(required = true)
    private String name;

    /**
     * 登录密码
     */
    @TableField("password")
    @ApiModelProperty(required = true)
    private String password;

    /**
     * 盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 头像
     */
    @TableField("image")
    private String image;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 状态
     0 暂时不可用
     1 永久不可用
     9 正常可用
     */
    @TableField("status")
    private Integer status;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 最后一次登录时间
     */
    @TableField("login_time")
    private Date loginTime;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

}
