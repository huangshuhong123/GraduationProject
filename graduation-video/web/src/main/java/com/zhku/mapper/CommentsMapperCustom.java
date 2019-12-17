package com.zhku.mapper;

import java.util.List;

import com.zhku.pojo.Comments;
import com.zhku.pojo.vo.CommentsVO;
import com.zhku.utils.MyMapper;

public interface CommentsMapperCustom extends MyMapper<Comments> {
	
	public List<CommentsVO> queryComments(String videoId);
}