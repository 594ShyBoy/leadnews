package com.lead.model.media.dto;

import com.lead.model.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * @ClassName WmMaterialDto
 * @date 2021/5/29 21:28
 * @Version 1.0
 * @Author ShyBoy
 */
@Data
public class WmMaterialDto extends PageRequestDto {
    /**
     * 是否收藏:
     *      1: 收藏了
     */
    Short isCollected; //1 查询收藏的
}
