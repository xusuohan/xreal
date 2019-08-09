package com.xreal.common.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author dpzhoufeng
 * @version 1.0
 * @date 2019/8/5
 */
@Component
//设置访问URL
@ServerEndpoint("/websocket/{userId}")
public class WebSocket {
  private static final Logger LOG = LoggerFactory.getLogger(WebSocket.class);
  private Session session;
  private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
  private static Map<String, Session> sessionPool = new HashMap<String, Session>();

  @OnOpen
  public void onOpen(Session session, @PathParam(value = "userId") String shopId) {
    this.session = session;
    webSockets.add(this);
    sessionPool.put(shopId, session);
    LOG.info("【websocket消息】有新的连接，总数为:" + webSockets.size());
  }

  @OnClose
  public void onClose() {
    webSockets.remove(this);
    LOG.info("【websocket消息】连接断开，总数为:" + webSockets.size());
   }

  /**
   * 收到客户端消息后调用的方法
   * @param message
   */
  @OnMessage
  public void onMessage(String message) {
    LOG.info("【websocket消息】收到客户端消息:" + message);
    sendOneMessage("DPS007","后端websocket收到来自前端消息：" + message);
  }

  /**
  群发消息
   */
  public void sendAllMessage(String message) {
    for (WebSocket webSocket : webSockets) {
      LOG.info("【websocket消息】广播消息:"+message);
      try {
        webSocket.session.getAsyncRemote().sendText(message);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 发送信息调用的方法
   * @param message
   * @throws Exception
   */
  // 此为单点消息
  public void sendOneMessage(String userId, String message) {
    Session session = sessionPool.get(userId);
    if (session != null) {
      try {
        session.getAsyncRemote().sendText(message);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  @OnError
  public void onError(Session session,Throwable error){
    LOG.info("发生错误");
    error.printStackTrace();

}

}






