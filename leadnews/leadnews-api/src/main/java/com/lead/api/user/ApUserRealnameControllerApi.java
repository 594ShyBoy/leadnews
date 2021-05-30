package com.lead.api.user;

import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.user.dtos.AuthDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName ApUserRealnameControllerApi
 * @date 2021/5/24 18:41
 * @Version 1.0
 * @Author ShyBoy
 */
@Api(value = "用户认证",tags = "用户认证",description = "用户认证API")
public interface ApUserRealnameControllerApi {
    /**
     * 按照状态查询用户认证列表
     * @param dto
     * @return
     * app端用户认证列表查询
     */
    @ApiOperation("app端用户认证列表查询")
    public ResponseResult loadListByStatus(AuthDto dto);

    /**
     * 审核通过
     * @param dto
     * @return
     */
    public ResponseResult authPass(AuthDto dto) ;

    /**
     * 审核失败
     * @param dto
     * @return
     */
    public ResponseResult authFail(AuthDto dto);
}
