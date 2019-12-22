package com.zhku.mapper;

import com.zhku.pojo.Videos;
import com.zhku.utils.MyMapper;

public interface VideosMapper extends MyMapper<Videos> {
    Videos getVideoInfo(String videoId);
}