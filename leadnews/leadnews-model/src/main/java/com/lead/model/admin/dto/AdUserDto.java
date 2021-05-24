package com.lead.model.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName AdUserDto
 * @date 2021/5/24 16:57
 * @Version 1.0
 * @Author ShyBoy
 */
@Data
public class AdUserDto {
    //用户名
    @ApiModelProperty("用户名")
    private String name;

    //密码
    @ApiModelProperty("密码")
    private String password;
}
