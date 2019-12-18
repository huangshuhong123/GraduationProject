package com.zhku.message.listener;


import com.google.common.collect.Lists;
import com.zhku.message.listener.config.QueueNameConfig;
import com.zhku.message.service.DsfMessageLogService;
import com.zhku.pojo.MessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 消息监听
 * @Author zhutao
 * @Date 2019/5/10
 **/
@Component
public class MessageListener {
    Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @Autowired
    private DsfMessageLogService dsfMessageLogService;


    /**
     * 站内信
     */
    @RabbitListener(queues = QueueNameConfig.MESSAGE_ZNX)
    public void handlerZnx(byte[] bytes){
        try {
            logger.info("站内信消息消费。。。");
            MessageRequest request = (MessageRequest)ObjectByteUtil.getObjectFromBytes(bytes);
            dsfMessageLogService.save(request);
        }catch (Exception e){
            logger.error("站内信消息消费失败！", e);
        }
    }


	

}
