package com.lead.model.media.dto;

import lombok.Data;

/**
 * @ClassName WmUserDto
 * @date 2021/5/29 16:23
 * @Version 1.0
 * @Author ShyBoy
 */
@Data
public class WmUserDto {
    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;
}
