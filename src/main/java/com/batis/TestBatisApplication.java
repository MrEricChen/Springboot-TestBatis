package com.batis;

//TODO 巨坑--org和tk配置不一致会报错
//import org.mybatis.spring.annotation.MapperScan;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@MapperScan(basePackages = "com.batis.mapper")
// 开启定时任务
//@EnableScheduling
// 开启异步
//@EnableAsync
//
@EnableSwagger2
public class TestBatisApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TestBatisApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TestBatisApplication.class);
    }
}
