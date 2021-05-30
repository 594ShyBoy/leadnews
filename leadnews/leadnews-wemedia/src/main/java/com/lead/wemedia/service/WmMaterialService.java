package com.lead.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.media.dto.WmMaterialDto;
import com.lead.model.media.pojo.WmMaterial;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName WmMaterialService
 * @date 2021/5/29 17:31
 * @Version 1.0
 * @Author ShyBoy
 */
public interface WmMaterialService extends IService<WmMaterial> {
    /**
     * 上传图片接口
     * @param multipartFile
     * @return
     */
    ResponseResult uploadPicture(MultipartFile multipartFile);

    /**
     * 素材列表查询
     * @param dto
     * @return
     */
    ResponseResult findList(WmMaterialDto dto);

    /**
     * 删除图片
     * @param
     * @return
     */
    ResponseResult delPicture(Integer id);

    /**
     * 收藏与取消收藏
     * @param
     * @param type
     * @return
     */
    ResponseResult updateStatus(Integer id, Short type);
}
