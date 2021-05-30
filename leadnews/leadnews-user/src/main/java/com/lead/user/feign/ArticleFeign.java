package com.lead.user.feign;

import com.lead.model.article.pojo.ApAuthor;
import com.lead.model.common.dtos.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName ArticleFeign
 * @date 2021/5/24 23:33
 * @Version 1.0
 * @Author ShyBoy
 */
@FeignClient("leadnews-article")    //往nacos注册中心注册的微服务名称
public interface ArticleFeign {
    @GetMapping("/api/v1/author/findByUserId/{id}")
    public ApAuthor findByUserId(@PathVariable("id") Integer id);

    @PostMapping("/api/v1/author/save")
    public ResponseResult save(@RequestBody ApAuthor apAuthor);
}
