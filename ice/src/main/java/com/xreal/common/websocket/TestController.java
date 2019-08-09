package com.xreal.common.websocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpzhoufeng
 * @version 1.0
 * @date 2019/8/5
 */
@RestController
@RequestMapping("api")
public class TestController {
  @Autowired
  private WebSocket webSocket;

  @RequestMapping("/sendAllWebSocket")
  public String test() {
    webSocket.sendAllMessage("来自群发的消息！");
    return "websocket群体发送！";
  }

  @RequestMapping("/sendOneWebSocket")
  public String sendOneWebSocket() {
    webSocket.sendOneMessage("DPS007", "发给指定用户的消息！");
    return "websocket单人发送";
  }
}
