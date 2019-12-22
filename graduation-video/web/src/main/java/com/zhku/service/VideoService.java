package com.zhku.service;

import java.util.List;

import com.zhku.pojo.Comments;
import com.zhku.pojo.Videos;
import com.zhku.utils.PagedResult;

public interface VideoService {
	
	/**
	 * @Description: 保存视频
	 */
	 String saveVideo(Videos video);
	
	/**
	 * @Description: 修改视频的封面
	 */
	 void updateVideo(String videoId, String coverPath);
	
	/**
	 * @Description: 分页查询视频列表
	 */
	 PagedResult getAllVideos(Videos video, Integer isSaveRecord,
                                    Integer page, Integer pageSize);
	
	/**
	 * @Description: 查询我喜欢的视频列表
	 */
	public PagedResult queryMyLikeVideos(String userId, Integer page, Integer pageSize);
	
	/**
	 * @Description: 查询我关注的人的视频列表
	 */
	 PagedResult queryMyFollowVideos(String userId, Integer page, Integer pageSize);
	
	/**
	 * @Description: 获取热搜词列表
	 */
	 List<String> getHotwords();
	
	/**
	 * @Description: 用户喜欢/点赞视频
	 */
	 void userLikeVideo(String userId, String videoId, String videoCreaterId);
	
	/**
	 * @Description: 用户不喜欢/取消点赞视频
	 */
	 void userUnLikeVideo(String userId, String videoId, String videoCreaterId);
	
	/**
	 * @Description: 用户留言
	 */
	 void saveComment(Comments comment);
	
	/**
	 * @Description: 留言分页
	 */
	 PagedResult getAllComments(String videoId, Integer page, Integer pageSize);

    Videos getVideoInfo(String videoId);

}


