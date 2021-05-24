package com.lead.wemedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lead.api.wemedia.WmUserControllerApi;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.common.enums.AppHttpCodeEnum;
import com.lead.model.media.pojo.WmUser;
import com.lead.wemedia.service.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName WmUserController
 * @date 2021/5/24 19:08
 * @Version 1.0
 * @Author ShyBoy
 */
@RestController
@RequestMapping("/api/v1/user")
public class WmUserController implements WmUserControllerApi {
    @Autowired
    private WmUserService wmUserService;

    /**
     * 保存自媒体用户
     * @param wmUser
     * @return
     */
    @Override
    @PostMapping("/save")
    public ResponseResult save(@RequestBody WmUser wmUser) {
        wmUserService.save(wmUser);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 根据名称查询自媒体用户
     * @param name
     * @return
     */
    @Override
    @GetMapping("/findByName/{name}")
    public WmUser findByName(@PathVariable("name") String name) {
        List<WmUser> list = wmUserService.list(Wrappers.<WmUser>lambdaQuery().eq(WmUser::getName, name));
        if(list!=null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
}
