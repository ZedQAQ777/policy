package com.zwj;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwj.dto.ProvinceInfo;
import com.zwj.dto.TimeInfo;
import com.zwj.entity.Policy;
import com.zwj.service.IPolicyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private IPolicyService policyService;
    @Test
    public void getRankTest(){
        final ArrayList<ProvinceInfo> allProvinceInfo = policyService.getAllProvinceInfo(new TimeInfo(LocalDate.now().minusYears(1), LocalDate.now()));
        allProvinceInfo.forEach(System.out::println);

    }
}
