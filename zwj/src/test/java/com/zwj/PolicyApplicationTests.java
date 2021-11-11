package com.zwj;
import com.zwj.entity.Policy;
import com.zwj.mapper.PolicyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PolicyApplicationTests {
    @Autowired
    PolicyMapper policyMapper;
    @Test
    void contextLoads() {
        final Policy policy = policyMapper.selectById("daf23aac-4307-11ec-a39a-fa163e761325");
        System.out.println(policy);
    }

}
