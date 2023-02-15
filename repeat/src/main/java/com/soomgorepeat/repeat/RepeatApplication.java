package com.soomgorepeat.repeat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RepeatApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){

		return builder.sources(RepeatApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(RepeatApplication.class, args);
	}

}
