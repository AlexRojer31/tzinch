package ru.alexrojer31.tzinch;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Tzinch {

	public static final Logger TZINCH = Logger.getLogger(Tzinch.class);

	public static void main(String[] args) {
		TZINCH.info("Tzinch started on 3000 port");
		SpringApplication.getShutdownHandlers().add(new Runnable() {
			@Override
			public void run() {
				TZINCH.info("Tzinch stopped.");
			}
		});
		SpringApplication.run(Tzinch.class, args);
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}


}
