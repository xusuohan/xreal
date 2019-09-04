package com.xreal.common.kafka;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.xreal.common.websocket.WebSocket;
/**
 * @author dpzhoufeng
 * @version 1.0
 * @date 2019/8/6
 * 简单定时任务实现
 */
@Component
public class ScheduledTasks {
  @Autowired
  private WebSocket webSocket;
  @Autowired
//定义一个kafka模板
  private KafkaTemplate<String, String> kafkaTemplate;
  private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
  private static final SimpleDateFormat DATA_RORMAT = new SimpleDateFormat("HH:mm:ss");
 /* @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    String msg = "kafka生成随机数："+(Math.random()*1000);
    kafkaTemplate.send("test2", msg);
    LOG.info("当前时间：", DATA_RORMAT.format(new Date()));
  }*/
 @Scheduled(fixedRate = 600)
 public void sendMessageBywebsocket(){
   int randomnumer  = (int) Math.round(Math.random() * 100);
   // LOG.info("随机数：" + randomnumer );
   int i = randomnumer%6;
   String name;
   switch (i){
     case 0:
       name="wj";
       break;
     case 1:
       name="lhp";
       break;
     case 2:
       name="qh360";
       break;
     case 3:
       name="51xyk";
       break;
     case 4:
       name="ppd";
       break;
     case 5:
       name="zbcash";
       break;
     default:
       name="zyd";
       break;
   }
   String date =  DATA_RORMAT.format(new Date());
   String msg = "{name:\"" + name + "\",value:" + randomnumer + ",datetime: \""+ date + "\"}";
   JSONObject jsonObject = JSON.parseObject(msg);
   String  jsonstring = jsonObject.toJSONString();
   String namevalue = "{name:\"" + name + "\",value:" + randomnumer + "}";
   JSONObject jsonname = JSON.parseObject(namevalue);
   String  jsonvalue = jsonname.toJSONString();
   webSocket.sendOneMessage("DPS008",jsonvalue);
   webSocket.sendOneMessage("DPS007",jsonstring );
   //LOG.info(jsonvalue);

 }
}
