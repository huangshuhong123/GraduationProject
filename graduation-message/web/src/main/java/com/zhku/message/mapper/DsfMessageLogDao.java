package com.zhku.message.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhku.pojo.DsfMessageLogEntity;
import com.zhku.pojo.MessageListReturnVo;
import com.zhku.utils.PagedResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-17 19:34:19
 */
@Mapper
public interface DsfMessageLogDao extends BaseMapper<DsfMessageLogEntity> {

    long save(DsfMessageLogEntity dsfMessageLogEntity);

    List<MessageListReturnVo> queryLists(@Param("userId") String userId);

	
}
