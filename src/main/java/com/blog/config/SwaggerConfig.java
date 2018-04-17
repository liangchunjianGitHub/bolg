package com.blog.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;


/**
 * Created by GD on 2018/3/8.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        Predicate<RequestHandler> swaggerSelector = RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class);
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(newArrayList(new ApiKey[]{this.apiKey()}))
//               .securitySchemes(newArrayList(new BasicAuth("test"))) //账号密码登录
//               .enable(false)   //禁止使用
                .apiInfo(apiInfo())
                .select()
//               .apis(RequestHandlerSelectors.basePackage("com.boot"))
                .apis(swaggerSelector)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("blog (exp for gd)")
                .description("用于学习web 框架的项目")
                .license("learn more")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
               // .contact(new Contact("GD","zhiping.top","455607047@qq.com"))
                .version("1.0")
                .build();
    }

    ApiKey apiKey() {
        return new ApiKey("sessionId", "sessionId", "header");
    }
}
