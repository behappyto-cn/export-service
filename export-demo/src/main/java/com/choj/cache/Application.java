package com.choj.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * <p>
 * Author Choj
 * Date 2022/1/24 20:43
 **/
@EnableScheduling
@SpringBootApplication
public class Application {

    /**
     * 入口
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
