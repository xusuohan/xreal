package com.xreal.common.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author dpzhoufeng
 * @version 1.0
 * @date 2019/8/5
 */
@Configuration
public class WebSocketConfig {
  /**
   * 注入ServerEndpointExporter，
   * 自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
   */
  @Bean
  public ServerEndpointExporter serverEndpointExporter() {
    return new ServerEndpointExporter();
  }

}
