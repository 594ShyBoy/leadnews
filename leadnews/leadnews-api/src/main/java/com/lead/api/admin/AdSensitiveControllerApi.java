package com.lead.api.admin;

import com.lead.model.admin.dto.SensitiveDto;
import com.lead.model.admin.pojo.AdSensitive;
import com.lead.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName SensitiveControllerApi
 * @date 2021/5/21 23:42
 * @Version 1.0
 * @Author ShyBoy
 */
@Api(value = "敏感词过滤",tags = "敏感词过滤",description = "敏感词过滤API")
public interface AdSensitiveControllerApi {


    /**
     * 根据名称分页查询敏感词
     * @param dto
     * @return
     */
    @ApiOperation("根据名称分页查询敏感词")
    public ResponseResult list(SensitiveDto dto);

    /**
     * 新增敏感词
     * @param adSensitive
     * @return
     */
    @ApiOperation("新增敏感词")
    public ResponseResult save(AdSensitive adSensitive);

    /**
     * 修改敏感词
     * @param adSensitive
     * @return
     */
    @ApiOperation("修改敏感词")
    public ResponseResult update(AdSensitive adSensitive);

    /**
     * 删除敏感词
     * @param id
     * @return
     */
    @ApiOperation("删除敏感词")
    public ResponseResult deleteById(Integer id);

}
