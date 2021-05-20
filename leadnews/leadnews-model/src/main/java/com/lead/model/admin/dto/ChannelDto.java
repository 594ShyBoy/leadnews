package com.lead.model.admin.dto;

import com.lead.model.common.dtos.PageRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName ChannelDto
 * @date 2021/5/20 23:31
 * @Version 1.0
 * @Author ShyBoy
 */
@Data
public class ChannelDto extends PageRequestDto {

    /**
     * 频道名称
     */
    @ApiModelProperty("频道名称")
    private String name;
}
