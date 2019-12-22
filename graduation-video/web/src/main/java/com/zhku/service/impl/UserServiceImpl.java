package com.zhku.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.zhku.message.MessageFeignClient;
import com.zhku.pojo.*;
import com.zhku.utils.ConstantUtil;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhku.mapper.UsersFansMapper;
import com.zhku.mapper.UsersLikeVideosMapper;
import com.zhku.mapper.UsersMapper;
import com.zhku.mapper.UsersReportMapper;
import com.zhku.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

	private  final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	public  MessageFeignClient messageFeignClient;

	@Autowired
	private UsersMapper userMapper;
	
	@Autowired
	private UsersFansMapper usersFansMapper;
	
	@Autowired
	private UsersLikeVideosMapper usersLikeVideosMapper;
	
	@Autowired
	private UsersReportMapper usersReportMapper;
	
	@Autowired
	private Sid sid;

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean queryUsernameIsExist(String username) {
		
		Users user = new Users();
		user.setUsername(username);
		
		Users result = userMapper.selectOne(user);
		
		return result == null ? false : true;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveUser(Users user) {
		
		String userId = sid.nextShort();
		user.setId(userId);
		userMapper.insert(user);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Users queryUserForLogin(String username, String password) {
		
		Example userExample = new Example(Users.class);
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("username", username);
		criteria.andEqualTo("password", password);
		Users result = userMapper.selectOneByExample(userExample);
		
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateUserInfo(Users user) {
		
		Example userExample = new Example(Users.class);
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("id", user.getId());
		userMapper.updateByExampleSelective(user, userExample);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Users queryUserInfo(String userId) {
		Example userExample = new Example(Users.class);
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("id", userId);
		Users user = userMapper.selectOneByExample(userExample);
		return user;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean isUserLikeVideo(String userId, String videoId) {

		if (StringUtils.isBlank(userId) || StringUtils.isBlank(videoId)) {
			return false;
		}
		
		Example example = new Example(UsersLikeVideos.class);
		Criteria criteria = example.createCriteria();
		
		criteria.andEqualTo("userId", userId);
		criteria.andEqualTo("videoId", videoId);
		
		List<UsersLikeVideos> list = usersLikeVideosMapper.selectByExample(example);
		
		if (list != null && list.size() >0) {
			return true;
		}
		
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveUserFanRelation(String userId, String fanId) {

		String relId = sid.nextShort();
		
		UsersFans userFan = new UsersFans();
		userFan.setId(relId);
		userFan.setUserId(userId);
		userFan.setFanId(fanId);
		
		usersFansMapper.insert(userFan);
		
		userMapper.addFansCount(userId);
		userMapper.addFollersCount(fanId);

		String fansName = userMapper.selectUserNameById(fanId);
		String faceUrl = userMapper.selectFaceUrlById(fanId);
		SimpleDateFormat formatter2 = new SimpleDateFormat("M月d日h点m分");
		String subTime = formatter2.format(new Date());

		List<String> userIds = new ArrayList<>();
		userIds.add(userId);

		//站内信
		Map<String, String> parametersZnxGr = new HashMap<>();
		parametersZnxGr.put("remark",fansName + " " + "在 " + subTime + " 关注了您哦~");
		String znxPcUrl = ""; //管理后台 跳转到意见建议详情页（暂时无法跳转）
		//地址暂定不知道
		String znxXcxUrl = faceUrl; //小程序 跳转到意见建议详情页
		String znxWxUrl = fanId; //urlZwwx;
		this.pushTaskMessage(ConstantUtil.YJJY_MESSAGE_ZNX_CODE, parametersZnxGr, userIds, null, null, znxPcUrl, znxWxUrl, znxXcxUrl);
	}

	public  void  pushTaskMessage(String templateCode, Map<String, String> messageParam, List<String> acceptUserIdList, List<String> acceptUserGroupIdList, List<String> acceptDeptartmentIdList,
								  String znxPcUrl, String znxWxUrl, String znxXcxUrl){
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setTemplateCode(templateCode);
		messageRequest.setMessageSendUserid(znxWxUrl);
		messageRequest.setMessageParam(messageParam);
		messageRequest.setAcceptUserIdList(acceptUserIdList);
		messageRequest.setAcceptUserGroupIdList(acceptUserGroupIdList);
		messageRequest.setAcceptDeptartmentIdList(acceptDeptartmentIdList);
		messageRequest.setZnxPcUrl(znxPcUrl);
		messageRequest.setZnxWxUrl(znxWxUrl);
		messageRequest.setZnxXcxUrl(znxXcxUrl);
		logger.info("messageRequest={}", JSONObject.toJSONString(messageRequest));
		String hello = messageFeignClient.hello();
		System.out.println(hello);
		messageFeignClient.sendMsg(messageRequest);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteUserFanRelation(String userId, String fanId) {
		
		Example example = new Example(UsersFans.class);
		Criteria criteria = example.createCriteria();
		
		criteria.andEqualTo("userId", userId);
		criteria.andEqualTo("fanId", fanId);
		
		usersFansMapper.deleteByExample(example);
		
		userMapper.reduceFansCount(userId);
		userMapper.reduceFollersCount(fanId);
		
	}

	@Override
	public boolean queryIfFollow(String userId, String fanId) {

		Example example = new Example(UsersFans.class);
		Criteria criteria = example.createCriteria();
		
		criteria.andEqualTo("userId", userId);
		criteria.andEqualTo("fanId", fanId);
		
		List<UsersFans> list = usersFansMapper.selectByExample(example);
		
		if (list != null && !list.isEmpty() && list.size() > 0) {
			return true;
		}
		
		return false;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void reportUser(UsersReport userReport) {
		
		String urId = sid.nextShort();
		userReport.setId(urId);
		userReport.setCreateDate(new Date());
		
		usersReportMapper.insert(userReport);
	}

	@Override
	public String findUserIdByVideoId(String videoId) {
		String userId = userMapper.findUserIdByVideoId(videoId);
		return userId;
	}

	@Override
	public List<String> queryAllUser() {
		List<String> userIds = userMapper.queryAllUser();
		return userIds;
	}

}

