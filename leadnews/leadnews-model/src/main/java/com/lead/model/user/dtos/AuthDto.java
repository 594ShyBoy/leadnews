package com.lead.model.user.dtos;

import com.lead.model.common.dtos.PageRequestDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName AuthDto
 * @date 2021/5/23 8:11
 * @Version 1.0
 * @Author ShyBoy
 */
@Data
public class AuthDto extends PageRequestDto {

    @ApiModelProperty("用户id")
    private Integer id;
    //驳回的信息
    @ApiModelProperty("驳回的信息")
    private String msg;
    //状态
    @ApiModelProperty("用户状态")
    private Short status;


}
