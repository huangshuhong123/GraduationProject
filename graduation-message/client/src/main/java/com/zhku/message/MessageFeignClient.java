package com.zhku.message;


import com.zhku.pojo.MessageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 推送消息-总入口
 */
@FeignClient(name="message")
public interface MessageFeignClient {
    /**
     * 消息推送
     * @param request
     * @return
     */
    @PostMapping(value = "/wx/message/sendMsg")
    void sendMsg(@RequestBody MessageRequest request);

    @RequestMapping(value = "/bgm/hello", method = RequestMethod.GET)
    String hello();

 }
