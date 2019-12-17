package com.zhku.message.service;


import com.baomidou.mybatisplus.service.IService;
import com.zhku.pojo.DsfMessageTemplateEntity;

import java.util.List;
import java.util.Map;

/**
 * 消息模板：所有类型都维护模板
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-05-21 15:52:16
 */
public interface DsfMessageTemplateService extends IService<DsfMessageTemplateEntity> {


    List<DsfMessageTemplateEntity> queryAll(Map<String, Object> params);

    void logicDelete(String id, int isDelete);
}

