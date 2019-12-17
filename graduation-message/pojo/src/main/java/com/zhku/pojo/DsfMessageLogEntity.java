package com.zhku.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 消息日志
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-05-21 15:52:09
 */
@TableName("tb_dsf_message_log")
@ApiModel(description = "消息日志")
@Data
public class DsfMessageLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 消息ID
	 */
    @ApiModelProperty(value = "消息ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long messageId;
	/**
	 * 消息模板编码
	 */
    @ApiModelProperty(value = "消息模板编码", example = "测试消息模板编码001")
    private String templateCode;
	/**
	 * 消息参数（匹配各类模板参数）
	 */
    @ApiModelProperty(value = "消息参数（匹配各类模板参数）", example = "测试消息参数（匹配各类模板参数）001")
    private String messageParam;
	/**
	 * 消息发送人id（系统触达时为0）
	 */
    @ApiModelProperty(value = "消息发送人id（系统触达时为0）", example = "测试消息发送人id（系统触达时为0）001")
    private String messageSendUserid;
	/**
	 * 用户ids（英文逗号隔开）
	 */
    @ApiModelProperty(value = "用户ids（英文逗号隔开）", example = "测试用户ids（英文逗号隔开）001")
    private String acceptUserIds;
	/**
	 * 组织id（英文逗号隔开）
	 */
    @ApiModelProperty(value = "组织id（英文逗号隔开）", example = "测试组织id（英文逗号隔开）001")
    private String acceptDeptartmentIds;
	/**
	 * 常用联系人分组id（英文逗号隔开）
	 */
    @ApiModelProperty(value = "常用联系人分组id（英文逗号隔开）", example = "测试常用联系人分组id（英文逗号隔开）001")
    private String acceptUserGroupIds;
	/**
	 * 发送时间(短信都发送给每一个人后在保存的表数据，所以发送时间记录在主表里面)
	 */
    @ApiModelProperty(value = "发送时间(短信都发送给每一个人后在保存的表数据，所以发送时间记录在主表里面)", example = "2018-08-08")
    private Date sendTime;
	/**
	 * 消息业务类型（01：管理员操作主动通知，02定时任务系统触达）冗余字段
	 */
    @ApiModelProperty(value = "消息业务类型（01：管理员操作主动通知，02定时任务系统触达）冗余字段", example = "测试消息业务类型（01：管理员操作主动通知，02定时任务系统触达）冗余字段001")
    private String messageBusinessType;
	/**
	 * 模板类型（01：站内信，02：政委微信文本消息，03：公共号文本消息，04：公共号模板消息。。。拓展其他）冗余字段
	 */
    @ApiModelProperty(value = "模板类型（01：站内信，02：政委微信文本消息，03：政务微信卡片消息，04：微信公众号文本消，,05：微信公众号模板消息。。。拓展其他）", example = "")
    private String templateType;
    /**
     * 模板类型（01：站内信，02：政委微信文本消息，03：公共号文本消息，04：公共号模板消息。。。拓展其他）冗余字段
     */
    @ApiModelProperty(value = "站内信管理后台端跳转地址", example = "www.baidu.com")
    private String znxPcUrl;
    /**
     * 模板类型（01：站内信，02：政委微信文本消息，03：公共号文本消息，04：公共号模板消息。。。拓展其他）冗余字段
     */
    @ApiModelProperty(value = "站内信政务微信端跳转地址", example = "www.baidu.com")
    private String znxWxUrl;
    /**
     * 模板类型（01：站内信，02：政委微信文本消息，03：公共号文本消息，04：公共号模板消息。。。拓展其他）冗余字段
     */
    @ApiModelProperty(value = "站内信小程序端跳转地址", example = "www.baidu.com")
    private String znxXcxUrl;

    /**
     * 用户id（获取请求参数）
     */
    @TableField(exist = false)
    private List<String> acceptUserIdList;
    /**
     * 组织id（获取请求参数）
     */
    @TableField(exist = false)
    private List<String> acceptDeptartmentIdList;
    /**
     * 常用联系人分组id（获取请求参数）
     */
    @TableField(exist = false)
    private List<String> acceptUserGroupIdList;

}
