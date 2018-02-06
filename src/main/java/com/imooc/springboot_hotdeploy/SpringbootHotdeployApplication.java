package com.imooc.springboot_hotdeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootHotdeployApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootHotdeployApplication.class);
//		return super.configure(builder);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHotdeployApplication.class, args);
    }
}
//-javaagent:/home/liux/.m2/repository/org/springframework/springloaded/1.2.8.RELEASE/springloaded-1.2.8.RELEASE.jar -noverify