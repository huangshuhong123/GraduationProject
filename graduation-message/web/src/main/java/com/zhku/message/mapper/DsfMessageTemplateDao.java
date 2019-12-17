package com.zhku.message.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhku.pojo.DsfMessageTemplateEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 消息模板：所有类型都维护模板
 * 
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-05-21 15:52:16
 */
@Mapper
public interface DsfMessageTemplateDao extends BaseMapper<DsfMessageTemplateEntity> {
	
}
