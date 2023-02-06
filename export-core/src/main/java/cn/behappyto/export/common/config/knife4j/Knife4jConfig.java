package cn.behappyto.export.common.config.knife4j;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Knife4jConfig
 *
 * @author wangmingcong
 */
@EnableSwagger2
@EnableKnife4j
@Configuration
public class Knife4jConfig {

    private static final String APP_ID = "fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9";
    private static final String APP_SECRET = "k9s78agm8eoi6xqmnrieob4mmc6q7zdq8najjb18rj31g962h0r9iwjr2qlqfbq6qnjrf7x7ji2xsdl56n80qxyd9tycy4cqlkw3zih3anrgbl9nh5r2vxk1w5qepcojci4h5nxwb9f3o7iorc07mwc13k2y7bkt4wkia2ddrwvdad9pj9slnzv3kl5cb0e1hahodbdae3gstn28tctyz1yq8yicpsr5chd3oh2zt315s9ixwv6emb1y5lohr4xgvqy8f99j9dwyub7cjjuzdkvz1rujjf2a16c287qqd561yh06q2ffqa2rwmu5w4jqpfoztenepgely8fdwlvy7b30zf2a25gzs3itppw0j0ifmwfm34xru44pc26j2c2euxyi763j9t5l467443vi7a6uvgj1bdg5p8vxqjolchjq20po5g4967o2umq2bydg6afv6tqbx2p1m3l7urwmsb4zz4llx73ej4wx9yup3xnvf7zvwnexrs620aiayrstwqa6khfkg7t35k66nidhtyooa3h1tqjz490zl0klwwv5skqzgjfkqftev6ct77q4dee98mczhv4s9t4st99aftkwzvbtkn20nj93exk4augzqni55zxmsvarmfbstrztftbdyh5256n0dj9hamsdpefjnqopgwo019pr98aasg8bz8ae557u548es2tml4xg44mf2d2v40ury6ty29a0t8p363l0qrwlu4rvig4q2micmtu4faxqk9z39gvu0a1c4l5gvmyu6vxdkzss0ghtff2u7yt39mzi0bkwcinvjkvk0s5z1jveb8tslews29fej6f44flvmeacpllfdjq1szl3kxwm9ciu5axmb87zrq2b0mo7axgrvso8ajr6ppxlaekmzt3i74fl4jjqipa3ow3z98aij5xqt3ayp5w8tw7rpt6vxrj67yyigkwokdgrofbh24373022ec6ghfms3ocsnt7rodoaww61xyv51nazmjd2sw5qet7snvn77dyqt1uiqh0dgxq580lyn31ztu56u4vl8lxah9ofd4pvkwtal8pn0j9wxge1ixjx0z3m8deah1plk3wtzlrifgzzgxgjfjcny4yk8c0rvniqpyz5jgak0od7wm49i8r6oslvbh1dtoo2fo7zev3u3k4u8so0tj7rbnh334uamokdgeilp2lhb752nzs6eqxe62ud3z9u3zzzz7g9acioqwlxtbpgcb0ahx44agz0so84d7aj0fyqoal0d03dreuzb967y7zi5knvfabxplj1jw5zbtz6ynknxy1l45otm4ynz4l38gt177srxt7f5dbude250osyxjkj02kh7zxt58cglc4rip4awpjhkcy4p1s5ew5bc9v152qoygmqe9qtq4huyv1fy6favn75v5uokz8ouqe7u7eimmbpto1wm4bjt7s5ygxypcd8bpjjyefqik66axc74xpkwjsvzdi0o5at43o2zrvfwxxyky2ivht7zmagl6kxg88mwp7kbd995e5qgbkvti1cd7nb1hxbldht1f3wxvr4umeuvjiijeqywzqv2xqsvfhvyjaec6bf9ke97ydmlmx8o75f8yenkcg0d7fuhwdc3wkhu3yyjle67y9ybpjibgxwcgw25eqhuhmzyb1is48byzm0yrd06acpv6oqncwm8ovn9q0gabjpe94nfsodc27jofzk2d6d6ma56xrqr48sd7qd6qybfu77xzx7x0eu9h0ibw8mk31nz17ktqvj6unn0kampf53vw50lhjpun8k9leny4l7m41524nho6pwxcdzvcw6dg4lf6qqw6sdpaylc5gsyghp6mz4bujiau7g0hfaeyzp39k97pj80gufve10beaw8kwzqob8mqvfhiohm2w6gxpliprg2ezzz1qkdu4qn5hd2eaow7vk3l0eszr3oqdk1812x9c35tyva8fp98jj7n2jk6c562e7so3z282lobjkdx0le7v45zt430ash51c33cxzwxniqbi97zowtgvjhhvn170";
    @Resource
    private ProjectConfig projectConfig;

    /**
     * Docket
     *
     * @return Docket
     */
    @Bean
    public Docket docket() {
        // 全局请求参数
        List<RequestParameter> requestParameters = new ArrayList<>();
        requestParameters.add(new RequestParameterBuilder()
                .name("appId")
                .description("appId的值，联系管理员或者到后台申请！")
                .in(ParameterType.HEADER)
                .query(parameterSpecificationBuilder ->
                        parameterSpecificationBuilder.defaultValue(APP_ID)
                                .allowEmptyValue(false))
                .required(true)
                .build());
        requestParameters.add(new RequestParameterBuilder()
                .name("appSecret")
                .description("appSecret的值，联系管理员或者到后台申请！")
                .in(ParameterType.HEADER)
                .query(parameterSpecificationBuilder ->
                        parameterSpecificationBuilder.defaultValue(APP_SECRET)
                                .allowEmptyValue(false))
                .required(true)
                .build());

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(this.builderApiInfo())
                .groupName(projectConfig.getGroupName())
                .globalRequestParameters(requestParameters)
                .host(projectConfig.getHost())
                .select()
                // 扫描所有带有 @ApiOperation 注解的类
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描所有的 controller
                .apis(RequestHandlerSelectors.basePackage(projectConfig.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建配置信息
     *
     * @return 返回 ApiInfo
     */
    private ApiInfo builderApiInfo() {
        ProjectConfig.Contact contact = projectConfig.getContact();
        return new ApiInfoBuilder()
                .termsOfServiceUrl(projectConfig.getTermsOfServiceUrl())
                .title(projectConfig.getTitle())
                .description(projectConfig.getDescription())
                .version(projectConfig.getVersion())
                .license(projectConfig.getLicense())
                .licenseUrl(projectConfig.getLicenseUrl())
                .contact(Optional.of(contact).isPresent() ?
                        new Contact(
                                contact.getName(),
                                contact.getUrl(),
                                contact.getEmail()
                        ) : null
                )
                .extensions(projectConfig.getExtensions())
                .build();
    }
}
