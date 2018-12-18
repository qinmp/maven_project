package com.socket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class SystemWebSocketHandler extends AbstractWebSocketHandler {
	private final static List<WebSocketSession> sessions = Collections.synchronizedList(new ArrayList<WebSocketSession>());
    
	private Logger logger=Logger.getLogger(SystemWebSocketHandler.class);
	
	//接收文本消息，并发送出去
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        chatTextMessageHandler(message.getPayload());
        super.handleTextMessage(session, message);
    }
    
    private void chatTextMessageHandler(String payload) {
    	logger.info("receive message = " + payload);
	}
    
	//连接建立后处理
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
    	try {
    		logger.info("connect to the websocket chat success......");
    		sessions.add(session);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
    }
    //抛出异常时处理
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception)  {
        try {
        	if(session.isOpen()){
        		session.close();
        	}
        	logger.info("websocket chat handleTransportError ......");
        	sessions.remove(session);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
    }
    //连接关闭后处理
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)  {
	    try {
	    	   logger.info("websocket chat connection closed......");
	    	   sessions.remove(session);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
