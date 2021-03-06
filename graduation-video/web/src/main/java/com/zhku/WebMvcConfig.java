package com.zhku;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zhku.controller.interceptor.MiniInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/** 静态资源处理 **/

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:/META-INF/resources/")
				//.addResourceLocations("file:/imooc-video/video/pic/");
		//.addResourceLocations("file:D:/迅雷下载/抖音全栈/pic/");
		.addResourceLocations("file:D:/video/");
	}
	
	@Bean(initMethod="init")
	public ZKCuratorClient zkCuratorClient() {
		return new ZKCuratorClient();
	}
	
	@Bean
	public MiniInterceptor miniInterceptor() {
		return new MiniInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(miniInterceptor()).addPathPatterns("/user/**")
				       .addPathPatterns("/video/upload", "/video/uploadCover",
				    		   			"/video/userLike", "/video/userUnLike",
				    		   			"/video/saveComment")
												  .addPathPatterns("/bgm/**")
												  .excludePathPatterns("/user/queryPublisher");
												  
		
	}

}
