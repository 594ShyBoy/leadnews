package com.lead.api.article;

import com.lead.model.article.pojo.ApAuthor;
import com.lead.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @ClassName AuthorControllerApi
 * @date 2021/5/24 20:04
 * @Version 1.0
 * @Author ShyBoy
 */
@Api(value = "App端作者管理",tags = "App端作者管理",description = "App端作者管理API")
public interface AuthorControllerApi {
    /**
     *根据用户id查询作者信息
     * @param id
     * @return
     */
    @ApiOperation("根据id查询App端作者")
    public ApAuthor findByUserId(Integer id);

    /**
     * 保存作者
     * @param apAuthor
     * @return
     */
    @ApiOperation("新增App端作者")
    public ResponseResult save(ApAuthor apAuthor);
}
