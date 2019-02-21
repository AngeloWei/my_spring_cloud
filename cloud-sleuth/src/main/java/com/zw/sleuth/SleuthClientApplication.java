package com.zw.sleuth;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SleuthClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthClientApplication.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    //注入Sampler，否则zipkin没有数据
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
