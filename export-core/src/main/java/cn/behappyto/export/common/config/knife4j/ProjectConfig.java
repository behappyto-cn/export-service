package cn.behappyto.export.common.config.knife4j;

import cn.hutool.core.util.RandomUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.VendorExtension;

import java.util.List;

/**
 * ProjectConfig
 *
 * @author wangmingcong
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "swagger")
public class ProjectConfig {

    /**
     * 扫描包
     */
    private String basePackage = "";

    /**
     * 分组名称
     */
    @Value("${spring.application.name:未配置}")
    private String groupName = "default-" + RandomUtil.randomNumbers(4);

    /**
     * 主机
     */
    private String host = "127.0.0.1";

    /**
     * 服务器 地址
     */
    private String termsOfServiceUrl = "http://127.0.0.1";

    /**
     * 标题
     */
    private String title = "系统文档";

    /**
     * 备注
     */
    private String description = "系统文档备注";

    /**
     * 版本
     */
    private String version = "1.0.0";

    /**
     * license
     */
    private String license;

    /**
     * license 地址
     */
    private String licenseUrl;

    /**
     * 联系方式
     */
    private Contact contact = new Contact();

    /**
     * 扩展参数
     */
    private List<VendorExtension> extensions;

    /**
     * 联系方式
     */
    @Getter
    @Setter
    public class Contact {

        /**
         * 姓名
         */
        private String name = "behappyto.cn";

        /**
         * 地址
         */
        private String url = "https://www.behappyto.cn";

        /**
         * 邮箱
         */
        private String email = "3630164024@qq.com";
    }
}
