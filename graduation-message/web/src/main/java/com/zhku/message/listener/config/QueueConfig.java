package com.zhku.message.listener.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 队列配置
 * @Author zhutao
 * @Date 2019/5/10
 **/
@Configuration
public class QueueConfig {
    /**
     * 站内信
     * @return
     */
    @Bean
    public Queue queueZnx() {
        return new Queue(QueueNameConfig.MESSAGE_ZNX);
    }

    /**
     * 政务微信-文本消息
     * @return
     */
    @Bean
    public Queue queueWxText() {
        return new Queue(QueueNameConfig.MESSAGE_WX_TEXT);
    }

    /**
     * 政务微信-卡片消息
     * @return
     */
    @Bean
    public Queue queueWxCard() {
        return new Queue(QueueNameConfig.MESSAGE_WX_CARD);
    }


    /**
     * 微信公众号-文本
     * @return
     */
    @Bean
    public Queue queueGzhText() {
        return new Queue(QueueNameConfig.MESSAGE_GZH_TEXT);
    }

    /**
     * 微信公众号-模板消息
     * @return
     */
    @Bean
    public Queue queueGzhTemp() {
        return new Queue(QueueNameConfig.MESSAGE_GZH_TEMP);
    }
    
    /**
     * 手机短信
     * @return
     */
    @Bean
    public Queue queueSms() {
        return new Queue(QueueNameConfig.MESSAGE_SMS);
    }
    
    /**
     * 手机短信
     * @return
     */
    @Bean
    public Queue queueSendSms() {
        return new Queue(QueueNameConfig.MSG_SMS);
    }
}
