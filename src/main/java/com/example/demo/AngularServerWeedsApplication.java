package com.example.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.service.StorageService;

@SpringBootApplication
public class AngularServerWeedsApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AngularServerWeedsApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/members");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/members/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT", "DELETE",
						"OPTIONS");
				registry.addMapping("/projects/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT", "DELETE",
						"OPTIONS");
				registry.addMapping("/post/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT", "DELETE",
						"OPTIONS");
				registry.addMapping("/getallfiles/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT", "DELETE",
						"OPTIONS");
			}

		};

	}
	
	@Resource
	StorageService storageService;
	
	@Override
	public void run(String... arg0) throws Exception {
//		storageService.deleteAll();
//		storageService.init();
	}
	
}



