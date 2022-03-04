package com.didispace.chapter11;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 *
 * @author Oliver
 */
@RestController
@RequestMapping ("/hiController")
public class HiController {
    @RequestMapping ("/hello")
    public String hello() {
        return "Hello Spring Boot 2";
    }
}
