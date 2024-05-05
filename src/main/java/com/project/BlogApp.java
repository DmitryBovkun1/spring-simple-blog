package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class BlogApp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(BlogApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BlogApp.class);
	}

	@ControllerAdvice
	public static class GlobalExceptionHandler {
		@ExceptionHandler(Exception.class)
		public ResponseEntity<Map<String, String>> handleException(Exception ex) {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "Internal server error. Please try again later.");
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}