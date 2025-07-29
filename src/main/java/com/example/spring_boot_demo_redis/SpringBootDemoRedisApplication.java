package com.example.spring_boot_demo_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootDemoRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoRedisApplication.class, args);
	}

}
