package com.pengpenghuyu.supportplat.quartzdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("quartz.xml")
public class App {

    private static final Logger Logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Logger.info("微服务入口函数编码-" + System.getProperty("file.encoding"));
        SpringApplication.run(App.class, args);
        System.out.println("################## 简单Quartz-Cluster微服务 ###################已启动.");
    }

}
