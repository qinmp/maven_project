package com.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		  registry.addHandler(SystemWebSocketHandler(),"/user/webSocketIMServer").setAllowedOrigins("*").addInterceptors(SystemHandShakeInterceptor());
	        registry.addHandler(SystemWebSocketHandler(), "/user/sockjs/webSocketIMServer").setAllowedOrigins("*").addInterceptors(SystemHandShakeInterceptor()).withSockJS();
	}

	@Bean
	SystemHandShakeInterceptor SystemHandShakeInterceptor() {
		// TODO Auto-generated method stub
		return new SystemHandShakeInterceptor();
	}

	@Bean
	SystemWebSocketHandler SystemWebSocketHandler() {
		// TODO Auto-generated method stub
		return new SystemWebSocketHandler();
	}

}
