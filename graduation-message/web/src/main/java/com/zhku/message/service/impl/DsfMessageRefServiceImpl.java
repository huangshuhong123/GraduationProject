package com.zhku.message.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhku.message.mapper.DsfMessageRefDao;
import com.zhku.message.service.DsfMessageRefService;
import com.zhku.pojo.DsfMessageRefPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author admin
 *
 */
@Service
public class DsfMessageRefServiceImpl extends ServiceImpl<DsfMessageRefDao, DsfMessageRefPO> implements DsfMessageRefService {
    @Resource
    private DsfMessageRefDao dsfMessageRefDao;

    @Override
    public void update(String userId, String terminalType,Date date) {
        dsfMessageRefDao.update(userId,terminalType,date);
    }

    @Override
    public void delete(List<Long> messageId) {
        //dsfMessageRefDao.delete(messageId);
    }


    @Override
    public void updateMessageState(List<Long> messageIds,String userId) {
        dsfMessageRefDao.updateMessageState(messageIds,userId);
    }

    @Override
    public int getUnreadCount(String terminalType,String userId) {
        return dsfMessageRefDao.getUnreadCount(terminalType,userId);
    }

    @Override
    public int getSiteUnreadCount(String terminalType, String userId,String site) {
        return dsfMessageRefDao.getSiteUnreadCount(terminalType,userId,site);
    }

}
