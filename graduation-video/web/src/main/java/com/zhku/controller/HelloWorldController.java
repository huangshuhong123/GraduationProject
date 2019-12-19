package com.zhku.controller;

import com.zhku.message.MessageFeignClient;
import com.zhku.utils.FeignResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@Resource
	private MessageFeignClient messageFeignClient;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		FeignResult hello = messageFeignClient.hello();
		System.out.println("hello" + hello);
		return "Hello Spring Boot~";
	}
	
}
