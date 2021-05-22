package com.lead.model.admin.dto;

import com.lead.model.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * @ClassName SensitiveDto
 * @date 2021/5/21 23:45
 * @Version 1.0
 * @Author ShyBoy
 */
@Data
public class SensitiveDto extends PageRequestDto {

    /**
     * 敏感词名称
     */
    private String name;

}
