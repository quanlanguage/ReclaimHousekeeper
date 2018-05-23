package com.duyun.huihsou.housekepper.pc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author haoshijing
 * @version 2018年05月23日 20:52
 **/
@ImportResource({"classpath:application-context.xml"})
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class PcStarter /*extends SpringBootServletInitializer */{

    public static void main(String[] args) {
        SpringApplication.run(PcStarter.class, args);
    }
}