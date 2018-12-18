package com.controller;

import java.util.Map;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class WebSocketStompController {
	 	@MessageMapping("/hello") //"/hello"为WebSocketConfig类中registerStompEndpoints()方法配置的  
	    @SendTo("/topic/greetings")  
	    public void greeting(@Header("atytopic") String topic, @Headers Map<String, Object> headers) {  
	        System.out.println("connected successfully....");  
	        System.out.println(topic);  
	        System.out.println(headers);  
	    }  
}
