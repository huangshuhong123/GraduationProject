package com.zhku.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 消息模板：所有类型都维护模板
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-05-21 15:52:16
 */
@ApiModel(description = "服务调用请求方式")
@Data
public class MessageRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 消息模板编码
     */
    @ApiModelProperty(value = "消息模板编码", example = "党费设置通知：DFGL0001")
    private String templateCode;
    /**
     * 消息参数（匹配各类模板参数）
     */
    @ApiModelProperty(value = "消息参数（匹配各类模板参数）", example = "")
    private Map messageParam;
    /**
     * 消息发送人id（系统触达时为0）
     */
    @ApiModelProperty(value = "消息发送人id（系统触达时为0）", example = "测试消息发送人id（系统触达时为0）")
    private String messageSendUserid;
    
    /**
     * 用户id（获取请求参数）
     */
    @ApiModelProperty(value = "用户id集合", example = "用户id集合")
    private List<String> acceptUserIdList;
    /**
     * 组织id（获取请求参数）
     */
    @ApiModelProperty(value = "组织id集合", example = "组织id集合")
    private List<String> acceptDeptartmentIdList;
    /**
     * 常用联系人分组id（获取请求参数）
     */
    @ApiModelProperty(value = "常用联系人分组id集合", example = "常用联系人分组id集合")
    private List<String> acceptUserGroupIdList;
    /**
     * 站内信管理后台端跳转地址
     */
    @ApiModelProperty(value = "站内信管理后台端跳转地址", example = "www.baidu.com")
    private String znxPcUrl;
    /**
     * 站内信政务微信端跳转地址
     */
    @ApiModelProperty(value = "站内信政务微信端跳转地址", example = "www.baidu.com")
    private String znxWxUrl;
    /**
     * 站内信小程序端跳转地址
     */
    @ApiModelProperty(value = "站内信小程序端跳转地址", example = "www.baidu.com")
    private String znxXcxUrl;


    /**
     * 消息模板对象
     */
    @ApiModelProperty(value = "消息模板对象", example = "消息模板对象")
    private DsfMessageTemplateEntity dsfMessageTemplateEntity;


    /**
     * 是否校验消息控制
     */
    @ApiModelProperty(value = "是否校验消息控制", example = "true")
    private boolean checkControl;
    
    /**
     * 组织机构id
     */
    @ApiModelProperty(value = "组织机构id", example = "String")
    private String orgId;
    
    @ApiModelProperty(value = "调用模块", example = "测试调用模块001")
    private String callModular;
    
    /**
     * 消息发送人姓名（系统触达时为0）
     */
    @ApiModelProperty(value = "消息发送人姓名", example = "消息发送人姓名（系统触达时为0）")
    private String messageSendUserName;
}
