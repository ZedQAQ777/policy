package com.zwj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwj.dto.ProvinceInfo;
import com.zwj.dto.TimeInfo;
import com.zwj.entity.Policy;
import com.zwj.mapper.PolicyMapper;
import com.zwj.service.IPolicyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 政策表 服务实现类
 * </p>
 *
 * @author zwj
 * @since 2021-11-11
 */
@Service
public class PolicyServiceImpl extends ServiceImpl<PolicyMapper, Policy> implements IPolicyService {
    @Autowired
    PolicyMapper policyMapper;
    @Override
    public ArrayList<ProvinceInfo> getAllProvinceInfo(TimeInfo timeInfo) {
        ArrayList<ProvinceInfo> provinceInfos = new ArrayList<>();
        QueryWrapper<Policy> qw = new QueryWrapper<>();
        qw.select("province,count(*) as policy_num");
        qw.groupBy("province");
        qw.orderByDesc("policy_num");
        qw.between("public_time", timeInfo.getStartTime(),timeInfo.getEndTime());
        List<Map<String, Object>> maps = policyMapper.selectMaps(qw);
        long max = (Long) maps.get(0).get("policy_num");
        for(Map<String, Object> map:maps){
            if(map.get("province")==null){
                continue;
            }
            String province = (String) map.get("province");
            Long policyNum = (Long) map.get("policy_num");
            ProvinceInfo provinceInfo = new ProvinceInfo(province,policyNum,getVitality(max,policyNum));
            provinceInfos.add(provinceInfo);
        }
        return provinceInfos;
    }
    private Long getVitality(long max, long cur){
        return  Math.round(cur*1.0/max*100);
    }
}
