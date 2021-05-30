package com.lead.article.controller.v1;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lead.api.article.AuthorControllerApi;
import com.lead.article.service.AuthorService;
import com.lead.model.article.pojo.ApAuthor;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.common.enums.AppHttpCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @ClassName AuthorController
 * @date 2021/5/24 20:11
 * @Version 1.0
 * @Author ShyBoy
 */
@RestController
@RequestMapping("/api/v1/author")
public class AuthorController implements AuthorControllerApi {
    @Autowired
    private AuthorService authorService;


    @GetMapping("/findByUserId/{id}")
    @Override
    public ApAuthor findByUserId(@PathVariable("id") Integer id) {
        List<ApAuthor> list = authorService.list(Wrappers.<ApAuthor>lambdaQuery().eq(ApAuthor::getUserId, id));
        if(list!=null &&!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @PostMapping("/save")
    @Override
    public ResponseResult save(@RequestBody ApAuthor apAuthor) {
        apAuthor.setCreatedTime(new Date());
        authorService.save(apAuthor);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);

    }
}
