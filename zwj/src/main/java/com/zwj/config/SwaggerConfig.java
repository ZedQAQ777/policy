package com.zwj.config;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置
 */
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.zwj.controller";
    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket helloDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                //用于分组功能，也可以不配置
                .groupName("zwj")
                //注册整体api信息
                .apiInfo(apiInfo())
                //swagger功能是否启用，可以通过配置设置，也可以先写死
                .enable(enableSwagger)
                .select()
                //指定扫描的包
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                //设置此组只匹配admin/**的请求
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("policy")
                .description("软工")
                .contact(new Contact("zwj", "", ""))
                .version("1.0.0")
                .build();
    }

}
