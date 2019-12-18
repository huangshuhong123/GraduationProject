package com.zhku.message.controller;



import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zhku.message.listener.ObjectByteUtil;
import com.zhku.message.listener.config.QueueNameConfig;
import com.zhku.message.service.DsfMessageTemplateService;
import com.zhku.message.utils.BaseUtil;
import com.zhku.pojo.DsfMessageTemplateEntity;
import com.zhku.pojo.MessageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "wx/message")
@RestController
@Api(tags = "消息推送")
public class WxMsgController{

    Logger logger = LoggerFactory.getLogger(WxMsgController.class);
    
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private DsfMessageTemplateService dsfMessageTemplateService;

    @ApiOperation(value = "推送消息-服务端入口")
    @PostMapping(value = "/sendMsg")
    public void sendMsg(@RequestBody MessageRequest request) {

        //todo(tangxt) :后期可将模板缓存处理，看具体性能。
        Wrapper<DsfMessageTemplateEntity> wrapper = new EntityWrapper<DsfMessageTemplateEntity>()
                .eq(BaseUtil.isNotEmpty(request.getTemplateCode()), "template_code", request.getTemplateCode());
        DsfMessageTemplateEntity templateEntity = dsfMessageTemplateService.selectOne(wrapper);
        request.setDsfMessageTemplateEntity(templateEntity);
        sendZnxtMsg(request);
    }

    @ApiOperation(value = "站内信推送消息")
    @PostMapping(value = "znx/context")
    public void sendZnxtMsg(@RequestBody MessageRequest request) {
        try {
            amqpTemplate.convertAndSend(QueueNameConfig.MESSAGE_ZNX, ObjectByteUtil.getBytesFromObject(request));
        } catch (Exception e) {
            logger.error("PC端消息生产失败！",e);
        }
    }


}
