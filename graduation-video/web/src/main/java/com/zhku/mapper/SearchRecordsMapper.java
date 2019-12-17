package com.zhku.mapper;

import java.util.List;

import com.zhku.pojo.SearchRecords;
import com.zhku.utils.MyMapper;

public interface SearchRecordsMapper extends MyMapper<SearchRecords> {
	
	public List<String> getHotwords();
}