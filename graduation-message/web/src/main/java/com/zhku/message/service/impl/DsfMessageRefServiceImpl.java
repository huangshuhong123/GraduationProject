package com.zhku.message.service.impl;

import cn.com.do1.dsf.compont.mysql.utils.PageUtils;
import cn.com.do1.dsf.compont.mysql.utils.Query;
import cn.com.do1.dsf.modules.entity.DsfMessageRefPO;
import cn.com.do1.modules.dao.DsfMessageRefDao;
import cn.com.do1.modules.service.DsfMessageRefService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
@Service("dsfMessageRefService")
public class DsfMessageRefServiceImpl extends ServiceImpl<DsfMessageRefDao, DsfMessageRefPO> implements DsfMessageRefService {
    @Resource
    private DsfMessageRefDao dsfMessageRefDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
		Long id = (Long)params.get("id");
		Boolean messageState = (Boolean)params.get("messageState");
        Page<DsfMessageRefPO> page = this.selectPage(
                new Query<DsfMessageRefPO>(params).getPage(),
                new EntityWrapper<DsfMessageRefPO>()
				.eq(id != null,"id", id)
				.eq(messageState != null,"message_state", messageState)
        );

        return new PageUtils(page);
    }

    @Override
    public void update(String userId, String terminalType,Date date) {
        dsfMessageRefDao.update(userId,terminalType,date);
    }

    @Override
    public void delete(List<Long> messageId) {
        //dsfMessageRefDao.delete(messageId);
    }

    @Override
    public PageUtils<DsfMessageRefPO> queryList(Map<String, Object> map){
        Page<DsfMessageRefPO> page =((Query)map).getPage();
        List<DsfMessageRefPO> list=  dsfMessageRefDao.queryList(page,map);
        page.setRecords(list);
        return new PageUtils(page);
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
