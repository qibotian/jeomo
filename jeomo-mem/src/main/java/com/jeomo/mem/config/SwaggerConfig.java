package com.jeomo.mem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${spring.application.name}")
    private String title;
	
	@Value("${spring.application.author}")
    private String author;
	
	@Value("${spring.application.author-url}")
    private String authorUrl;
	
	@Value("${spring.application.email}")
    private String email;
	
	@Value("${spring.application.description}")
    private String description;
	
	
	@Bean
	public Docket docker(Environment env) {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		boolean testOrDevEnv = env.acceptsProfiles(Profiles.of("dev", "test"));
		
		//只在测试环境或者开发环境中开启swagger
		docket.enable(testOrDevEnv);
		
		ApiInfo apiInfo = apiInfo();
		docket
			.apiInfo(apiInfo)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.jeomo")) //指定扫描包
			.build();
		return docket;
	}
	
	

	private ApiInfo apiInfo() {
	      Contact contact = new Contact(author, authorUrl, email);
		String license = "Apache 2.0";
		String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";
		String termsOfServiceUrl = "www.jiumeng.org";
		String version = "1.1.0";
		return new ApiInfo(title, description, version , termsOfServiceUrl, contact, license, licenseUrl);
	}

}
