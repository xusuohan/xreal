package com.xreal.common.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpzhoufeng
 * @version 1.0
 * @date 2019/8/6
 * 生产者测试
 */
//定义控制器，通过浏览器访问
@RestController
@RequestMapping("kafka")
public class TestKafkaProducerController {

  @Autowired
  //定义kafka模板
  private KafkaTemplate<String, String> kafkaTemplate;
  /* @RequestMapping("send")
  public String send(String msg){
     //使用kafka模板发送信息
     kafkaTemplate.send("test2", msg);
     return "发送消息"+msg+"success";
  }*/
}

