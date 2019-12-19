package com.zhku.message.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="背景音乐业务的接口", tags= {"背景音乐业务的controller"})
@RequestMapping("/bgm")

public class HelloWorldControllerTest {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ApiOperation(value="获取背景音乐列表", notes="获取背景音乐列表的接口")
	public String hello() {
		return "Hello Spring Boot~";
	}
	
}
