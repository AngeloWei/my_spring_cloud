package com.zw.sleuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/9101/hi")
    public String testService() {
        return restTemplate.getForObject("http://localhost:9101/9101/hi/value",String.class);
    }
    @RequestMapping("/9101/hi/value")
    public String testService1() {
        return "9101";
    }
    @RequestMapping("/9100/hi/value")
    public String testService2() {
        return "9100";
    }
    @RequestMapping("/9100/hi")
    public String testService3() {
        return  restTemplate.getForObject("http://localhost:9100/9100/hi/value", String.class);
    }
}
