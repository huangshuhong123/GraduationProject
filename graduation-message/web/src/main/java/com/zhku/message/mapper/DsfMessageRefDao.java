package com.zhku.message.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhku.pojo.DsfMessageRefPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-17 19:34:32
 */
@Mapper
public interface DsfMessageRefDao extends BaseMapper<DsfMessageRefPO> {

    void update(@Param("userId") String userId, @Param("terminalType") String terminalType, @Param("date") Date date);

    void delete(@Param("messageIds") List<Long> messageIds, @Param("userId") String userId);

    public List<DsfMessageRefPO> queryList(Page<DsfMessageRefPO> page, Map<String, Object> map);

    void updateMessageState(@Param("messageId") Long messageId, @Param("userId") String userId);

    int getUnreadCount(@Param("terminalType") String terminalType, @Param("userId") String userId);

    int getSiteUnreadCount(@Param("terminalType") String terminalType, @Param("userId") String userId, @Param("site") String site);

}