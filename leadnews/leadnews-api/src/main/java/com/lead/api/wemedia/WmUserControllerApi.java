package com.lead.api.wemedia;

import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.media.pojo.WmUser;

/**
 * @ClassName WmUserControllerApi
 * @date 2021/5/24 19:05
 * @Version 1.0
 * @Author ShyBoy
 */
public interface WmUserControllerApi {
    /**
     * 保存自媒体用户
     * @param wmUser
     * @return
     */
    public ResponseResult save(WmUser wmUser);

    /**
     * 按照名称查询用户
     * @param name
     * @return
     */
    public WmUser findByName(String name);
}
