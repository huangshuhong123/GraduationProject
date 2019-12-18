package com.zhku.message.service.impl;



import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhku.message.mapper.DsfMessageTemplateDao;
import com.zhku.message.service.DsfMessageTemplateService;
import com.zhku.message.utils.BaseUtil;
import com.zhku.pojo.DsfMessageTemplateEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dsfMessageTemplateService")
public class DsfMessageTemplateServiceImpl extends ServiceImpl<DsfMessageTemplateDao, DsfMessageTemplateEntity> implements DsfMessageTemplateService {



    @Override
    public List<DsfMessageTemplateEntity> queryAll(Map<String, Object> params) {
        return this.selectList(getEntityWrapper(params));
    }

	@Override
	public void logicDelete(String id,int isDelete) {
		DsfMessageTemplateEntity entity = selectById(id);
		if(BaseUtil.isNotEmpty(entity)){
			entity.setIsDelete(isDelete);
			updateById(entity);
		}
	}

	private Wrapper<DsfMessageTemplateEntity> getEntityWrapper(Map<String, Object> params) {
        String module = (String) params.get("module");
        String moduleName = (String) params.get("moduleName");
        String messageBusinessType = (String) params.get("messageBusinessType");
        String templateType = (String) params.get("templateType");
        String templateCode = (String) params.get("templateCode");
        String templateName = (String) params.get("templateName");
        String templateContent = (String) params.get("templateContent");
        String templateRemark = (String) params.get("templateRemark");

        return new EntityWrapper<DsfMessageTemplateEntity>()
                .like(StringUtils.isNotEmpty(module), "module", module)
                .like(StringUtils.isNotEmpty(moduleName), "module_name", moduleName)
                .like(StringUtils.isNotEmpty(messageBusinessType), "message_business_type", messageBusinessType)
                .like(StringUtils.isNotEmpty(templateType), "template_type", templateType)
                .like(StringUtils.isNotEmpty(templateCode), "template_code", templateCode)
                .like(StringUtils.isNotEmpty(templateName), "template_name", templateName)
                .like(StringUtils.isNotEmpty(templateContent), "template_content", templateContent)
                .like(StringUtils.isNotEmpty(templateRemark), "template_remark", templateRemark)
                ;
    }

}
