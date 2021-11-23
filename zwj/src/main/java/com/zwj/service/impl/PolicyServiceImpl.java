package com.zwj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwj.dto.ProvinceInfo;
import com.zwj.dto.TimeInfo;
import com.zwj.entity.Policy;
import com.zwj.mapper.PolicyMapper;
import com.zwj.service.IPolicyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.util.CommonResult;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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
    private  List<String> provinces;
    @Autowired
    PolicyMapper policyMapper;
    @Override
    public ArrayList<ProvinceInfo> getAllProvinceInfo(TimeInfo timeInfo) {
        initProvinces();
        ArrayList<ProvinceInfo> provinceInfos = new ArrayList<>();
        QueryWrapper<Policy> qw = new QueryWrapper<>();
        qw.select("province,count(*) as policy_num");
        qw.groupBy("province");
        qw.between("public_time", timeInfo.getStartTime(),timeInfo.getEndTime());
        qw.orderByDesc("policy_num");
        List<Map<String, Object>> maps = policyMapper.selectMaps(qw);
        long max;
        if(maps.size()==0){
            max = 0;
        }
        else max = (Long) maps.get(0).get("policy_num");
        for(Map<String, Object> map:maps){
            if(map.get("province")==null||map.get("province")=="国务院"){
                continue;
            }
            String province = (String) map.get("province");
            Long policyNum = (Long) map.get("policy_num");
            ProvinceInfo provinceInfo = new ProvinceInfo(province,policyNum,getVitality(max,policyNum));
            provinceInfos.add(provinceInfo);
        }
        for(String province: provinces){
            ProvinceInfo provinceInfo = new ProvinceInfo();
            provinceInfo.setProvince(province);
            if(!provinceInfos.contains(provinceInfo)){
                provinceInfo.setPolicyNum((long)0);
                provinceInfo.setVitality((long)0);
                provinceInfos.add(provinceInfo);
            }
        }
        return provinceInfos;
    }
    private Long getVitality(long max, long cur){
        if(max==0){
            return (long)0;
        }
        return  (long)Math.sqrt(Math.sqrt(Math.round(cur*1.0/max*100))*10)*10;
    }
    private void initProvinces(){
        if(provinces==null){
            provinces = Arrays.asList(
                    "河北省","山西省","辽宁","吉林","黑龙江","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东","海南","四川","贵州","云南","陕西","甘肃","青海","台湾",
                    "内蒙古","广西","西藏","宁夏","新疆",
                    "北京","天津市","上海","重庆",
                    "香港","澳门"
            );
        }
    }
}
