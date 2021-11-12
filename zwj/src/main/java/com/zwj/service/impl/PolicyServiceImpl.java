package com.zwj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwj.dto.ProvinceInfo;
import com.zwj.entity.Policy;
import com.zwj.mapper.PolicyMapper;
import com.zwj.service.IPolicyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

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
    public ProvinceInfo getVitality(String province) {
        QueryWrapper<Policy> wrapper = new QueryWrapper<>();
        wrapper.eq("province","福建");
        final Long count = policyMapper.selectCount(wrapper);
        return new ProvinceInfo(province,count,0);
    }
}
