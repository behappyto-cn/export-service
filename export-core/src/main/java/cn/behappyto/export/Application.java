package cn.behappyto.export;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author behappyto.cn
 */
@EnableScheduling
@SpringBootApplication
@MapperScan(value = "cn.behappyto.export.domain.dao.mapper")
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
