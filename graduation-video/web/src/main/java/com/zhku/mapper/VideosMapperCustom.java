package com.zhku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhku.pojo.Videos;
import com.zhku.pojo.vo.VideosVO;
import com.zhku.utils.MyMapper;

public interface VideosMapperCustom extends MyMapper<Videos> {
	
	/**
	 * @Description: 条件查询所有视频列表
	 */
	public List<VideosVO> queryAllVideos(@Param("videoDesc") String videoDesc,
                                         @Param("userId") String userId);
	
	/**
	 * @Description: 查询关注的视频
	 */
	public List<VideosVO> queryMyFollowVideos(String userId);
	
	/**
	 * @Description: 查询点赞视频
	 */
	public List<VideosVO> queryMyLikeVideos(@Param("userId") String userId);
	
	/**
	 * @Description: 对视频喜欢的数量进行累加
	 */
	public void addVideoLikeCount(String videoId);
	
	/**
	 * @Description: 对视频喜欢的数量进行累减
	 */
	public void reduceVideoLikeCount(String videoId);
}