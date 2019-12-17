package com.zhku.message.service;



import com.baomidou.mybatisplus.service.IService;
import com.zhku.pojo.DsfMessageRefPO;

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
public interface DsfMessageRefService extends IService<DsfMessageRefPO> {

    PageUtils queryPage(Map<String, Object> params);

    void update(String userId, String terminalType, Date date);

    void delete(List<Long> messageId);

    public PageUtils<DsfMessageRefPO> queryList(Map<String, Object> map);

    void updateMessageState(List<Long> messageIds, String userId);

    int getUnreadCount(String terminalType, String userId);

    int getSiteUnreadCount(String terminalType, String userId, String site);


}

