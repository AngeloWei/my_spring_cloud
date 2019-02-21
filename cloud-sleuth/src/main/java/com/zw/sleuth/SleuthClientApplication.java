package com.zw.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication

@RestController
public class SleuthClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthClientApplication.class, args);
    }


    @RequestMapping("/hi")
    public String testService() {
        return "请求的服务。。sleuth";
    }
}
