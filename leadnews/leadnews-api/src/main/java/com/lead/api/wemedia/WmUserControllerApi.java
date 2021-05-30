package com.lead.api.wemedia;

import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.media.pojo.WmUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName WmUserControllerApi
 * @date 2021/5/24 19:05
 * @Version 1.0
 * @Author ShyBoy
 */
@Api(value = "自媒体用户管理",tags = "自媒体用户管理",description = "自媒体用户管理API")
public interface WmUserControllerApi {
    /**
     * 保存自媒体用户
     * @param wmUser
     * @return
     */
    @ApiOperation("新增自媒体用户")
    public ResponseResult save(WmUser wmUser);

    /**
     * 按照名称查询用户
     * @param name
     * @return
     */
    @ApiOperation("根据name查询自媒体用户")
    public WmUser findByName(String name);
}
