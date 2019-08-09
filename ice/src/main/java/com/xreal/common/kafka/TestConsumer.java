package com.xreal.common.kafka;


import com.xreal.common.websocket.WebSocket;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author dpzhoufeng
 * @version 1.0
 * @date 2019/8/6
 * 消费者测试
 */
@Component
  public class TestConsumer {
  @Autowired
  private WebSocket webSocket;
  private static final Logger LOG = LoggerFactory.getLogger(TestConsumer.class);
  @KafkaListener(topics = "test2")
  //定义此消费者接收topic为“test2”的消息
  public void listen (ConsumerRecord<?, ?> record) throws Exception {
    LOG.info("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    LOG.info(record.toString());
    webSocket.sendOneMessage("DPS007", "来自kafka的问候:"+record.value().toString());
  }
}
