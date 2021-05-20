package com.lead.api.admin;

import com.lead.model.admin.dto.ChannelDto;
import com.lead.model.admin.pojo.AdChannel;
import com.lead.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName AdChannelControllerApi
 * @date 2021/5/20 23:28
 * @Version 1.0
 * @Author ShyBoy
 */
@Api(value = "频道管理",tags = "频道管理",description = "频道管理API")
public interface AdChannelControllerApi {

    /**
     * 根据名称分页查询频道列表
     * @param dto
     * @return
     */
    @ApiOperation("根据名称分页查询频道列表")
    public ResponseResult findByNameAndPage(ChannelDto dto);

    /**
     * 频道管理
     * @param adChannel
     * @return
     */
    @ApiOperation("频道保存")
    public ResponseResult save(AdChannel adChannel);

    /**
     * 频道修改
     * @param adChannel
     * @return
     */
    @ApiOperation("频道修改")
    public ResponseResult update(AdChannel adChannel);

    /**
     * 频道删除
     * @param id
     * @return
     */
    @ApiOperation("频道删除")
    public ResponseResult deleteById(Integer id);

}
