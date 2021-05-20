package com.lead.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lead.model.admin.dto.ChannelDto;
import com.lead.model.admin.pojo.AdChannel;
import com.lead.model.common.dtos.ResponseResult;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName AdChannelService
 * @date 2021/5/20 23:38
 * @Version 1.0
 * @Author ShyBoy
 */
public interface AdChannelService extends IService<AdChannel> {
    /**
     * 根据名称分页查询频道列表
     * @param dto
     * @return
     */
    public ResponseResult findByNameAndPage(ChannelDto dto);

    /**
     *
     * @param adChannel
     * @return
     */
    public ResponseResult insert(AdChannel adChannel);

    /**
     * 频道修改
     * @param adChannel
     * @return
     */
    public ResponseResult update(AdChannel adChannel);

    /**
     * 频道删除
     * @param id
     * @return
     */
    public ResponseResult deleteById(Integer id);
}
