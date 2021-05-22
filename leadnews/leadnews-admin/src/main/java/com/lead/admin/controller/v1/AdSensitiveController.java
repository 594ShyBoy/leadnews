package com.lead.admin.controller.v1;

import com.lead.admin.service.AdSensitiveService;
import com.lead.api.admin.AdSensitiveControllerApi;
import com.lead.model.admin.dto.SensitiveDto;
import com.lead.model.admin.pojo.AdSensitive;
import com.lead.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SensitiveController
 * @date 2021/5/21 23:54
 * @Version 1.0
 * @Author ShyBoy
 */
@RestController
@RequestMapping("/api/v1/sensitive")
@CrossOrigin
public class AdSensitiveController implements AdSensitiveControllerApi {
    @Autowired
    private AdSensitiveService adSensitiveService;

    @PostMapping("/list")
    @Override
    public ResponseResult list(@RequestBody SensitiveDto dto) {
        return adSensitiveService.list(dto);
    }

    @PostMapping("/save")
    @Override
    public ResponseResult save(@RequestBody AdSensitive adSensitive) {
        return adSensitiveService.insert(adSensitive);
    }

    @PostMapping("/update")
    @Override
    public ResponseResult update(@RequestBody AdSensitive adSensitive) {
        return adSensitiveService.update(adSensitive);
    }
    @DeleteMapping("/del/{id}")
    @Override
    public ResponseResult deleteById(@PathVariable Integer id) {
        return adSensitiveService.deleteById(id);
    }
}
