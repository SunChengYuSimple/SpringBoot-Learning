package com.oliver.experiment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置切换控制器
 * @author Oliver
 */
@RestController
@RequestMapping ("/propertiesController")
public class PropertiesController {

    @Value ("${db:}")
    private String db;

    /**
     * 从 yaml 配置文件中获取参数
     */
    @Value ("${mq:}")
    private String mq;

    @RequestMapping ("properties")
    public String properties () {
        return db + "<br/>" + mq;
    }
}
