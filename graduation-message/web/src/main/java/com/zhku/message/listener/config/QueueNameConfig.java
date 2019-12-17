package com.zhku.message.listener.config;

/**
 * @Description 队列名称
 * @Author zhutao
 * @Date 2019/5/10
 **/
public class QueueNameConfig {
    //政务微信消息推送队列
    public final static String MESSAGE_WX_CARD = "queue_message_wx_card";
    //政务微信消息推送队列
    public final static String MESSAGE_WX_TEXT = "queue_message_wx_text";
    //微信公众号消息推送队列
    public final static String MESSAGE_GZH_TEMP = "queue_message_gzh_temp";
    //微信公众号消息推送队列
    public final static String MESSAGE_GZH_TEXT = "queue_message_gzh_text";
    //站内信推送队列
    public final static String MESSAGE_ZNX = "queue_message_znx";

    //短信推送队列
    public final static String MESSAGE_SMS = "queue_message_sms";
    
    public final static String MSG_SMS = "queue_msg_sms";
}
