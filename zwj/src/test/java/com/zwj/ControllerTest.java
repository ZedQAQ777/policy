package com.zwj;
import com.zwj.controller.PolicyController;
import com.zwj.dto.ProvinceInfo;
import com.zwj.dto.TimeInfo;
import com.zwj.service.IPolicyService;
import com.zwj.util.CommonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
    @Autowired
    private PolicyController policyController;
    @Test
    public void listAllTest(){
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setStartTime(LocalDate.now().minusYears(1));
        timeInfo.setEndTime(LocalDate.now());
        final CommonResult<List<ProvinceInfo>> result = policyController.listAll(timeInfo);
        System.out.println(result);
    }
    @Test
    public void getTotalTest(){
        final CommonResult<Long> result = policyController.getTotal("广东");
        System.out.println(result);

    }

}
