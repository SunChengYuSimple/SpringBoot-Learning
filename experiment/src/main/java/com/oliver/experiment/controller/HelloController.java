package com.oliver.experiment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Controller
 * @author Oliver
 */
@RestController
@RequestMapping("/helloController")
public class HelloController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot 2";
    }
    
    
}
