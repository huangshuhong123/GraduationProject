package com.zhku.message;


import com.zhku.message.hystrix.MessageClientHystrix;
import com.zhku.pojo.MessageRequest;
import com.zhku.utils.FeignResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 推送消息-总入口
 */
@FeignClient(name="message",fallback = MessageClientHystrix.class)
public interface MessageFeignClient {
    /**
     * 消息推送
     * @param request
     * @return
     */
    @PostMapping(value = "/wx/message/sendMsg")
    FeignResult sendMsg(@RequestBody MessageRequest request);

    @RequestMapping(value = "/bgm/hello", method = RequestMethod.GET)
    FeignResult hello();

 }
