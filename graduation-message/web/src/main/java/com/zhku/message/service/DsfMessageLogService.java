package com.zhku.message.service;


import com.baomidou.mybatisplus.service.IService;
import com.zhku.pojo.DsfMessageLogEntity;
import com.zhku.pojo.MessageRequest;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-17 19:34:19
 */
public interface DsfMessageLogService extends IService<DsfMessageLogEntity> {


    Long save(MessageRequest request);



}

