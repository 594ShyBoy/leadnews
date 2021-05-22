package com.lead.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lead.model.admin.dto.SensitiveDto;
import com.lead.model.admin.pojo.AdSensitive;
import com.lead.model.common.dtos.ResponseResult;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName AdSensitiveService
 * @date 2021/5/21 23:57
 * @Version 1.0
 * @Author ShyBoy
 */
public interface AdSensitiveService extends IService<AdSensitive> {
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
    public ResponseResult insert(AdSensitive adSensitive);

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
