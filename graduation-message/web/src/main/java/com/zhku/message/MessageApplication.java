package com.zhku.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages="com.zhku.message.mapper")
@ComponentScan(basePackages= {"com.zhku"})
public class MessageApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class,args);
	}
	
}
