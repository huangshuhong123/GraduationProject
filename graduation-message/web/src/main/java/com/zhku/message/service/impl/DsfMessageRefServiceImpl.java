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
@Service("dsfMessageRefService")
public class DsfMessageRefServiceImpl extends ServiceImpl<DsfMessageRefDao, DsfMessageRefPO> implements DsfMessageRefService {
    @Resource
    private DsfMessageRefDao dsfMessageRefDao;

}
