package com.zhku.service;

import java.util.List;

import com.zhku.pojo.Bgm;

public interface BgmService {
	
	/**
	 * @Description: 查询背景音乐列表
	 */
	 List<Bgm> queryBgmList();
	
	/**
	 * @Description: 根据id查询bgm信息
	 */
	 Bgm queryBgmById(String bgmId);
}
