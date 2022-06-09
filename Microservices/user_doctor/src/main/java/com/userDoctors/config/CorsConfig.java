package com.userDoctors.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig {
	
	@Value("${allowed.origin}")
	private  String allowedOrigin;
	@Bean
	public WebMvcConfigurer getCorsConfiguration() {
		return new WebMvcConfigurer() {
	
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/doctor/**") 
						.allowedOrigins(allowedOrigin)
						.allowedMethods("*")
						.allowedHeaders("Access-Control-Allow-Origin","http://localhost:4200");
			}
		};
	}

}


/*
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
}
*/
