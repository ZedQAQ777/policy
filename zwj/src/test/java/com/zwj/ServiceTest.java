package com.zwj;

import com.zwj.dto.ProvinceInfo;
import com.zwj.service.IPolicyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private IPolicyService policyService;
    @Test
    public void getVitalityTest(){
        final ProvinceInfo provinceInfo = policyService.getVitality("福建");
        System.out.println(provinceInfo);
    }
}
