package com.lead.admin.controller.v1;

import com.lead.admin.service.AdChannelService;
import com.lead.api.admin.AdChannelControllerApi;
import com.lead.model.admin.dto.ChannelDto;
import com.lead.model.admin.pojo.AdChannel;
import com.lead.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AdChannelController
 * @date 2021/5/21 0:15
 * @Version 1.0
 * @Author ShyBoy
 */
@RestController
@RequestMapping("/api/v1/channel")
public class AdChannelController implements AdChannelControllerApi {

    @Autowired
    private AdChannelService adChannelService;

    @PostMapping("/list")
    @Override
    public ResponseResult findByNameAndPage(@RequestBody ChannelDto dto) {
        return adChannelService.findByNameAndPage(dto);
    }

    @PostMapping("/save")
    @Override
    public ResponseResult save(@RequestBody AdChannel adChannel) {
        return adChannelService.insert(adChannel);
    }

    @PostMapping("/update")
    @Override
    public ResponseResult update(@RequestBody AdChannel adChannel) {
        return adChannelService.update(adChannel);
    }

    @DeleteMapping("/del/{id}")
    @Override
    public ResponseResult deleteById(@PathVariable("id") Integer id) {
        return adChannelService.deleteById(id);
    }
}
