package com.kthsoft.spring.websocket.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kthsoft.spring.websocket.demo.message.Greeting;
import com.kthsoft.spring.websocket.demo.message.HelloMessage;

@Controller
public class WebsocketController {

	@RequestMapping("/")
	public String websocket() {
		return "websocket";
	}
	
	@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }
	
}
