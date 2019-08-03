package io.choerodon.choerodonstudyservice;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("io.choerodon")
@SpringBootApplication
@EnableEurekaClient
@EnableChoerodonResourceServer
public class ChoerodonStudyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChoerodonStudyServiceApplication.class, args);
    }

}
