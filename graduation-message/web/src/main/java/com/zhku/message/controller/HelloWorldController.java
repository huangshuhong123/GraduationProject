package com.zhku.message.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="背景音乐业务的接口", tags= {"背景音乐业务的controller"})
@RequestMapping("/bgm")

public class HelloWorldController {
	
	@RequestMapping("/hello")
	@ApiOperation(value="获取背景音乐列表", notes="获取背景音乐列表的接口")

	public String Hello() {
		return "Hello Spring Boot~";
	}
	
}
