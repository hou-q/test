package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2的接口配置
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${spring.profiles.active}")
	private String env;

	/**
	 * 创建API
	 */
	@Bean
	public Docket createRestApi() {

		return new Docket(DocumentationType.SWAGGER_2)
				// 详细定制
				.apiInfo(apiInfo()).enable("dev".equals(env)).select()
				// 指定当前包路径
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				// 扫描所有 .apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	/**
	 * 添加摘要信息
	 */
	private ApiInfo apiInfo() {
		// 用ApiInfoBuilder进行定制
		return new ApiInfoBuilder().title("标题：测试 API").description("描述：测试.").version("版本号：1.0.0").build();
	}
}
