package com.zw.sleuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
public class SleuthClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthClientApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @RequestMapping("/9100/hi")
    public String testService() {
        return restTemplate.getForObject("http://localhost:9101/hi/value",String.class);
    }
    @RequestMapping("/9100/hi/value")
    public String testService1() {
        return "9100";
    }
    @RequestMapping("/9101/hi/value")
    public String testService2() {
        return "9101";
    }
    @RequestMapping("/9101/hi")
    public String testService3() {
      return  restTemplate.getForObject("http://localhost:9100/hi/value", String.class);
    }

}
