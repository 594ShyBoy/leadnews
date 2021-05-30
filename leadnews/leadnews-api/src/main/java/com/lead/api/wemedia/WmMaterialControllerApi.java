package com.lead.api.wemedia;

import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.media.dto.WmMaterialDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName WmMaterialControllerApi
 * @date 2021/5/29 17:29
 * @Version 1.0
 * @Author ShyBoy
 */
public interface WmMaterialControllerApi {
    /**
     * 上传图片
     * @param multipartFile
     * @return
     */
    ResponseResult uploadPicture(MultipartFile multipartFile);

    /**
     * 素材列表
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
     * 取消收藏
     * @param
     * @return
     */
    ResponseResult cancleCollectionMaterial(Integer id);

    /**
     * 收藏图片
     * @param
     * @return
     */
    ResponseResult collectionMaterial(Integer id);
}
