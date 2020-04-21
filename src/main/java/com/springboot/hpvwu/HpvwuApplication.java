package com.springboot.hpvwu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("com.springboot.hpvwu.mapper")
public class HpvwuApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpvwuApplication.class, args);
    }

}
