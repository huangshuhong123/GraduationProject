package com.zhku.message.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhku.message.mapper.DsfMessageLogDao;
import com.zhku.message.service.DsfMessageLogService;
import com.zhku.message.service.DsfMessageRefService;
import com.zhku.message.utils.MessageConvertor;
import com.zhku.pojo.DsfMessageLogEntity;
import com.zhku.pojo.DsfMessageRefPO;
import com.zhku.pojo.MessageRequest;
import com.zhku.utils.BaseUtil;
import com.zhku.utils.JsonUtils2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 
 * @author admin
 *
 */
@Service("dsfMessageLogService")
public class DsfMessageLogServiceImpl extends ServiceImpl<DsfMessageLogDao, DsfMessageLogEntity> implements DsfMessageLogService {

	@Resource
	private DsfMessageLogDao dsfMessageLogDao;

	@Autowired
	private DsfMessageRefService dsfMessageRefService;



	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long save(MessageRequest request) {
		DsfMessageLogEntity dsfMessageLogEntity = new DsfMessageLogEntity();
		dsfMessageLogEntity.setTemplateCode(request.getTemplateCode());
		dsfMessageLogEntity.setMessageParam(JsonUtils2.toJson(request.getMessageParam()));
		dsfMessageLogEntity.setMessageSendUserid(request.getMessageSendUserid());
		dsfMessageLogEntity.setAcceptUserIds(String.join(",",
				BaseUtil.isNotEmpty(request.getAcceptUserIdList()) ? request.getAcceptUserIdList() : Lists.newArrayList()));
		dsfMessageLogEntity.setAcceptUserGroupIds(String.join(",",
				BaseUtil.isNotEmpty(request.getAcceptUserGroupIdList()) ? request.getAcceptUserGroupIdList() : Lists.newArrayList()));
		dsfMessageLogEntity.setAcceptDeptartmentIds(String.join(",",
				BaseUtil.isNotEmpty(request.getAcceptDeptartmentIdList()) ? request.getAcceptDeptartmentIdList() : Lists.newArrayList()));
		dsfMessageLogEntity.setSendTime(new Date());
		dsfMessageLogEntity.setMessageBusinessType(request.getDsfMessageTemplateEntity().getMessageBusinessType());
		dsfMessageLogEntity.setTemplateType(request.getDsfMessageTemplateEntity().getTemplateType());
		//站内信跳转地址-只针对站内信
		dsfMessageLogEntity.setZnxPcUrl(request.getZnxPcUrl());
		dsfMessageLogEntity.setZnxWxUrl(request.getZnxWxUrl());
		dsfMessageLogEntity.setZnxXcxUrl(request.getZnxXcxUrl());
		insert(dsfMessageLogEntity);

		//获取所有接收人
		List<String> userIdList = getUserIdList(request);
		Long messageId = dsfMessageLogEntity.getMessageId();
		if (BaseUtil.isNotEmpty(userIdList)) {
			for (String userId : userIdList) {
				DsfMessageRefPO dsfMessageRefEntity = new DsfMessageRefPO();
				dsfMessageRefEntity.setMessageId(messageId);
				dsfMessageRefEntity.setMessageAcceptId(userId);
				//补充个性化用户信息
				getUserInfo(userId,request);
				String content = MessageConvertor.getSendContent(request);
				dsfMessageRefEntity.setMessageContent(content);
				dsfMessageRefEntity.setMessageState(0);
				dsfMessageRefEntity.setDeleteFlag(0);
				/*带扩展字段
				dsfMessageRefEntity.setSuccessCode();
				dsfMessageRefEntity.setApiPushCode();*/
				dsfMessageRefEntity.setCreateTime(new Date());
				dsfMessageRefService.insert(dsfMessageRefEntity);
			}
		}
		return messageId;
	}





}
