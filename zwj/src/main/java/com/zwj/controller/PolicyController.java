package com.zwj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwj.dto.ProvinceInfo;
import com.zwj.dto.TimeInfo;
import com.zwj.entity.Policy;
import com.zwj.service.IPolicyService;
import com.zwj.util.CommonResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Api(tags = "生产者进程API接口")
@Validated
@RestController
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private IPolicyService policyService;
    @ApiOperation(value = "查询一段时间内所有省份政策数量，并按活跃度排序",notes = "日期为yyyy-MM-dd格式")
    @GetMapping(value = "/listAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime", value = "开始日期",
                    required = true, dataTypeClass = LocalDate.class),
            @ApiImplicitParam(name = "endTime", value = "结束日期",
                    required = true, dataTypeClass = LocalDate.class),
    })
    public CommonResult<List<ProvinceInfo>> listAll(TimeInfo timeInfo) {
        final ArrayList<ProvinceInfo> provinceInfos = policyService.getAllProvinceInfo(timeInfo);
        return CommonResult.success(provinceInfos);
    }


    @ApiOperation("通过省份查询政策总数")
    @GetMapping("/getAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份",
                    required = true, dataTypeClass = LocalDate.class),
    })
    public CommonResult<Long> getTotal (@NotBlank(message = "省份不能为空")String province) {
        QueryWrapper<Policy> wrapper = new QueryWrapper<>();
        wrapper.eq("province",province);
        final Long count = policyService.count(wrapper);
        return CommonResult.success(count);
    }
}
