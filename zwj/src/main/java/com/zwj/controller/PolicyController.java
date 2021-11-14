package com.zwj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwj.dto.ProvinceInfo;
import com.zwj.dto.TimeInfo;
import com.zwj.entity.Policy;
import com.zwj.service.IPolicyService;
import com.zwj.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 政策表 前端控制器
 * </p>
 *
 * @author zwj
 * @since 2021-11-11
 */
@Api(description = "生产者进程API接口")
@RestController
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private IPolicyService policyService;

    @ApiOperation("查询所有省份信息，并按活跃度排序")
    @GetMapping(value = "/listAll")
    public CommonResult<List<ProvinceInfo>> listAll(TimeInfo timeInfo) {
        final ArrayList<ProvinceInfo> provinceInfos = policyService.getAllProvinceInfo(timeInfo);
        return CommonResult.success(provinceInfos);
    }
}
