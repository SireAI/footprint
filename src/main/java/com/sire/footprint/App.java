package com.sire.footprint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * ==================================================
 * All Right Reserved
 * Date:2017/8/3
 * Author:Sire
 * Description:
 * ==================================================
 */
@SpringBootApplication()
@EnableWebMvc
@EnableTransactionManagement
@MapperScan("com.sire.controller.post.dao")
@RestController
@EnableScheduling
@EnableCaching
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping("/")
    public String test() {
        return "hello sire!";
    }


}
