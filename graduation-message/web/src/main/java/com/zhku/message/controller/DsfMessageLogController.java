package com.zhku.message.controller;

import com.zhku.message.service.DsfMessageLogService;
import com.zhku.pojo.MessageListReturnVo;
import com.zhku.utils.PagedResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * zhutao
 */
@Api(tags = "消息日志")
@RestController
@RequestMapping("/dsf/messageLog")
public class DsfMessageLogController {
    @Autowired
    private DsfMessageLogService dsfMessageLogService;

    @GetMapping("/list")
    @ApiOperation("查询消息日志列表")
    public PagedResult list(@RequestParam String userId,@RequestParam Integer page, @RequestParam Integer pageSize){
        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = 10;
        }
        PagedResult pageUtil = dsfMessageLogService.queryList(userId,page,pageSize);
        return pageUtil;
    }


}
