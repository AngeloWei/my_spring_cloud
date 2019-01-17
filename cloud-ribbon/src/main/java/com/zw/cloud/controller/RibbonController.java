package com.zw.cloud.controller;

import com.zw.cloud.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;
    @GetMapping("/test/ribbon1")
    public String getString1() {
      return   ribbonService.EurekaClientService()+"===========1";
    }
    @GetMapping("/test/ribbon2")
    public String getString2() {
        return   ribbonService.EurekaClientService()+"===========2";
    }
}
