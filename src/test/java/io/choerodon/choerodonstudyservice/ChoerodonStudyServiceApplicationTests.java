package io.choerodon.choerodonstudyservice;

import io.choerodon.choerodonstudyservice.infra.feign.IamFeign;
import io.choerodon.choerodonstudyservice.infra.mapper.OrgaizationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChoerodonStudyServiceApplicationTests {

    @Autowired
    IamFeign iamFeign;
    @Autowired
    OrgaizationMapper orgaizationMapper;
    @Test
    public void contextLoads() {
        System.out.println(orgaizationMapper.selectAll());
    }

}
