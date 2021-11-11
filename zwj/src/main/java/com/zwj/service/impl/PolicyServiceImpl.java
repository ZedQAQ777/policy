package com.zwj.service.impl;

import com.zwj.entity.Policy;
import com.zwj.mapper.PolicyMapper;
import com.zwj.service.IPolicyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
