package com.lead.user.feign;

import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.media.pojo.WmUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName WemediaFeign
 * @date 2021/5/24 23:37
 * @Version 1.0
 * @Author ShyBoy
 */
@FeignClient("leadnews-wemedia")    //往nacos注册中心注册的微服务名称
public interface WemediaFeign {
    /**
     * 保存自媒体用户
     * @param wmUser
     * @return
     */
    @PostMapping("/api/v1/user/save")
    public ResponseResult save(@RequestBody WmUser wmUser);

    /**
     * 根据名称查询自媒体用户
     * @param name
     * @return
     */
    @GetMapping("/api/v1/user/findByName/{name}")
    public WmUser findByName(@PathVariable("name") String name);
}
