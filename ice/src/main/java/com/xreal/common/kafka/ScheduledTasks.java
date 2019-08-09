package com.xreal.common.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dpzhoufeng
 * @version 1.0
 * @date 2019/8/6
 * 简单定时任务实现
 */
@Component
public class ScheduledTasks {
  @Autowired
//定义一个kafka模板
  private KafkaTemplate<String, String> kafkaTemplate;
  private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
  private static final SimpleDateFormat DATA_RORMAT = new SimpleDateFormat("HH:mm:ss");
  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    String msg = "kafka生成随机数："+(Math.random()*1000);
    kafkaTemplate.send("test2", msg);
    LOG.info("当前时间：", DATA_RORMAT.format(new Date()));
  }
}
