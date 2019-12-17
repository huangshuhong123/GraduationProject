package com.zhku.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 消息模板：所有类型都维护模板
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-05-21 15:52:16
 */
@TableName("tb_dsf_message_template")
@ApiModel(description = "消息模板：所有类型都维护模板")
@Data
public class DsfMessageTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
    @ApiModelProperty(value = "id")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
	/**
	 * 业务模板（数据字典）
	 */
    @ApiModelProperty(value = "业务模板（数据字典）", example = "测试业务模板（数据字典）001")
    private String module;
	/**
	 * 业务模块名称（数据字典）-冗余字段
	 */
    @ApiModelProperty(value = "业务模块名称（数据字典）-冗余字段", example = "测试业务模块名称（数据字典）-冗余字段001")
    private String moduleName;
	/**
	 * 消息业务类型（01：管理员操作主动通知，02定时任务系统触达）
	 */
    @ApiModelProperty(value = "消息业务类型（01：管理员操作主动通知，02定时任务系统触达）", example = "测试消息业务类型（01：管理员操作主动通知，02定时任务系统触达）001")
    private String messageBusinessType;
	/**
	 * 模板类型（01：站内信，02：政委微信文本消息，03：政务微信卡片消息，04：微信公众号文本消，,05：微信公众号模板消息。。。拓展其他）
	 */
    @ApiModelProperty(value = "", example = "模板类型（01：站内信，02：政委微信文本消息，03：政务微信卡片消息，04：微信公众号文本消，,05：微信公众号模板消息。。。拓展其他）")
    private String templateType;
	/**
	 * 模板编码8为唯一（如：DF000001:党费消息以DF开头）
	 */
    @ApiModelProperty(value = "模板编码8为唯一（如：DF000001:党费消息以DF开头）", example = "测试模板编码8为唯一（如：DF000001:党费消息以DF开头）001")
    private String templateCode;
	/**
	 * 模板名称（党费设置审批通过通知设置人消息）
	 */
    @ApiModelProperty(value = "模板名称（党费设置审批通过通知设置人消息）", example = "测试模板名称（党费设置审批通过通知设置人消息）001")
    private String templateName;
	/**
	 * 消息模板
	 */
    @ApiModelProperty(value = "消息模板", example = "测试消息模板001")
    private String templateContent;
	/**
	 * 消息模板说明
	 */
    @ApiModelProperty(value = "消息模板说明", example = "测试消息模板说明001")
    private String templateRemark;
	/**
	 * (如公众号模板消息：需要在微信公众平台申请模板，获取这个id)
	 */
    @ApiModelProperty(value = "(如公众号模板消息：需要在微信公众平台申请模板，获取这个id)", example = "测试(如公众号模板消息：需要在微信公众平台申请模板，获取这个id)001")
    private String applyTemplateId;
	/**
	 * 生效状态（0有效，1失效）
	 */
    @ApiModelProperty(value = "生效状态（0有效，1失效）", example = "0")
    private int isDelete;
}
