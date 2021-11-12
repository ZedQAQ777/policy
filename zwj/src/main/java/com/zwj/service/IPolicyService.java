package com.zwj.service;

import com.zwj.dto.ProvinceInfo;
import com.zwj.entity.Policy;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 政策表 服务类
 * </p>
 *
 * @author zwj
 * @since 2021-11-11
 */
public interface IPolicyService extends IService<Policy> {
    public ProvinceInfo getVitality(String province);
}
