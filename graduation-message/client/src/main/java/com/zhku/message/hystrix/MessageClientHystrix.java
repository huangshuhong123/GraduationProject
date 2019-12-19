package com.zhku.message.hystrix;


import com.zhku.message.MessageFeignClient;
import com.zhku.pojo.MessageRequest;
import com.zhku.utils.FeignResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class MessageClientHystrix implements MessageFeignClient {

    @Override
    public FeignResult sendMsg(@RequestBody MessageRequest request) {
        return new FeignResult().HYSTRIX_ERROR;
    }

    @Override
    public FeignResult hello() {
        return new FeignResult().HYSTRIX_ERROR;
    }
}
