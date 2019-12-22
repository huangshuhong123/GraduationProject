package com.zhku.message.controller;


import com.zhku.message.service.DsfMessageRefService;
import com.zhku.utils.BaseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * zhutao
 */
@Api(tags = "消息日志-接收人日志")
@RestController
@RequestMapping("/dsf/messageRef")
public class DsfMessageRefController{
    @Autowired
    private DsfMessageRefService dsfMessageRefService;

    @PostMapping("/updateMessageState")
    @ApiOperation("更新消息状态")
    public void updateMessageState(@RequestParam Long messageId,@RequestParam String userId){
            dsfMessageRefService.updateMessageState(messageId,userId);
    }


    @GetMapping("/getUnreadCount")
    @ApiOperation("查询未读消息数量")
    public Integer getUnreadCount(@RequestParam String terminalType,@RequestParam String userId){
        return dsfMessageRefService.getUnreadCount(terminalType,userId);
    }
    
    @GetMapping("/getSiteUnreadCount")
    @ApiOperation("查询未读消息数量")
    public Integer getSiteUnreadCount(@RequestParam String terminalType, String site,String userId){
       
        return dsfMessageRefService.getSiteUnreadCount(terminalType,userId,site);
    }
}
