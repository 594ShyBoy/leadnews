package com.lead.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lead.common.constants.user.UserConstants;
import com.lead.model.article.pojo.ApAuthor;
import com.lead.model.common.dtos.PageResponseResult;
import com.lead.model.common.dtos.ResponseResult;
import com.lead.model.common.enums.AppHttpCodeEnum;
import com.lead.model.media.pojo.WmUser;
import com.lead.model.user.dtos.AuthDto;
import com.lead.model.user.pojo.ApUser;
import com.lead.model.user.pojo.ApUserRealname;
import com.lead.user.feign.ArticleFeign;
import com.lead.user.feign.WemediaFeign;
import com.lead.user.mapper.ApUserMapper;
import com.lead.user.mapper.ApUserRealnameMapper;
import com.lead.user.service.ApUserRealnameService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ClassName ApUserRealnameServiceImpl
 * @date 2021/5/23 8:20
 * @Version 1.0
 * @Author ShyBoy
 */
@Service
public class ApUserRealnameServiceImpl extends ServiceImpl<ApUserRealnameMapper, ApUserRealname> implements ApUserRealnameService {
    @Override
    public ResponseResult loadListByStatus(AuthDto dto) {
        //参数为空
        if (dto == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //检查参数
        dto.checkParam();
        LambdaQueryWrapper<ApUserRealname> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (dto.getStatus() != null){
            lambdaQueryWrapper.eq(ApUserRealname::getStatus,dto.getStatus());
        }
        IPage pageParam =  new Page(dto.getPage(),dto.getSize());
        IPage page = page(pageParam,lambdaQueryWrapper);
        PageResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(), (int) page.getTotal());
        //responseResult.setCode(0);
        responseResult.setData(page.getRecords());
        return responseResult;
    }

    /**
     * 修改认证用户状态
     * @param dto
     * @param status
     * @return
     */
    @Override
    @GlobalTransactional
    @Transactional
    public ResponseResult updateStatusById(AuthDto dto, Short status) {
        //1. 检查参数
        if (dto == null || dto.getId() == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);   //无效参数
        }
        //1.1 检查状态
        if (checkStatus(status)){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);   //无效参数
        }

        //2. 修改状态
        ApUserRealname apUserRealname = new ApUserRealname();
        apUserRealname.setId(dto.getId());
        apUserRealname.setStatus(status);
        if (dto.getMsg() != null){
            apUserRealname.setReason(dto.getMsg());
        }
        updateById(apUserRealname);

        //3. 如果审核状态是通过,则创建自媒体账户,并创建作者信息
        if (status.equals(UserConstants.PASS_AUTH)){
            //创建自媒体账户 创建作者信息
            //int a = 1/0;
            ResponseResult result = createWmUserAndAuthor(dto);
            if (result != null){
                return result;
            }

        }
        //int a = 1/0;
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Autowired
    private ApUserMapper apUserMapper;

    @Autowired
    private WemediaFeign wemediaFeign;

    /**
     * 创建自媒体账户 创建作者信息
     * @param dto
     */
    private ResponseResult createWmUserAndAuthor(AuthDto dto) {
        //获取ap_user信息
        Integer apUserRealnameId = dto.getId();
        ApUserRealname apUserRealname = getById(apUserRealnameId);
        ApUser apUser = apUserMapper.selectById(apUserRealname.getUserId());
        if (apUser == null){
            //说明传过来的参数有误
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);   //无效参数
        }

        WmUser wmUser = wemediaFeign.findByName(apUser.getName());

        //创建自媒体账户
        if (wmUser == null){
            wmUser = new WmUser();
            wmUser.setApUserId(apUser.getId());
            wmUser.setCreatedTime(new Date());
            wmUser.setName(apUser.getName());
            wmUser.setPassword(apUser.getPassword());
            wmUser.setSalt(apUser.getSalt());
            wmUser.setPhone(apUser.getPhone());
            wmUser.setStatus(9);
            wemediaFeign.save(wmUser);
        }

        //创建作者信息
        createAuthor(wmUser);
        apUser.setFlag((short)1);   //标识为一个自媒体人
        apUserMapper.updateById(apUser);

        return null;

    }

    @Autowired
    private ArticleFeign articleFeign;
    /**
     * 创建作者信息
     * @param wmUser
     */
    private void createAuthor(WmUser wmUser) {
        Integer apUserId = wmUser.getApUserId();
        ApAuthor apAuthor = articleFeign.findByUserId(apUserId);
        if (apAuthor == null){
            apAuthor = new ApAuthor();
            apAuthor.setName(wmUser.getName());
            apAuthor.setCreatedTime(new Date());
            apAuthor.setUserId(apUserId);
            apAuthor.setType(UserConstants.AUTH_TYPE);
            articleFeign.save(apAuthor);
        }
    }

    /**
     * 检查状态
     * @param status
     * @return
     */
    private boolean checkStatus(Short status) {
        if (status == null || (!status.equals(UserConstants.FAIL_AUTH) && !status.equals(UserConstants.PASS_AUTH))){
            return true;
        }
        return false;
    }
}












