package com.zhku.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息列表返回
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-05-21 15:52:16
 */
@Data
public class MessageListReturnVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息模板编码
     */
    @ApiModelProperty(value = "消息id", example = "消息id")
    private String messageId;
    /**
     * 消息参数（匹配各类模板参数）
     */
    @ApiModelProperty(value = "业务模块编码", example = "业务模块编码")
    private String module;
    /**
     * 消息发送人id（系统触达时为0）
     */
    @ApiModelProperty(value = "业务模块", example = "业务模块   ")
    private String moduleName;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容", example = "消息内容   ")
    private String messageContent;

    /**
     * 用户id（获取请求参数）
     */
    @ApiModelProperty(value = "发送时间", example = "发送时间")
    private Date sendTime;
    /**
     * 组织id（获取请求参数）
     */
    @ApiModelProperty(value = "消息状态0未读，1已读", example = "消息状态0未读，1已读")
    private int messageState;
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


}
