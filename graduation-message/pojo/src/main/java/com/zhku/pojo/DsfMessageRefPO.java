package com.zhku.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息接收人表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-05-21 15:52:00
 */
@TableName("tb_dsf_message_ref")
@ApiModel(description = "消息接收人表")
@Data
public class DsfMessageRefPO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
    @ApiModelProperty(value = "主键id", example = "1")
    @JSONField(serializeUsing = ToStringSerializer.class)
    @TableId
    private Long id;
    
    @ApiModelProperty(value = "消息ID", example = "1")
    @TableId
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long messageId;
	/**
	 * 接收人
	 */
    @ApiModelProperty(value = "接收人", example = "测试接收人001")
    private String messageAcceptId;
	/**
	 * 用户接受到的消息内容（仅限文本消息，如果模板消息：保存参数即可）
	 */
    @ApiModelProperty(value = "用户接受到的消息内容（仅限文本消息，如果模板消息：保存参数即可）", example = "测试用户接受到的消息内容（仅限文本消息，如果模板消息：保存参数即可）001")
    private String messageContent;
	/**
	 * 消息状态（0：未读，1：已读）
	 */
    @ApiModelProperty(value = "消息状态（0：未读，1：已读）", example = "true")
    private int messageState;
	/**
	 * 生效状态（0：有效，1：无效）
	 */
    @ApiModelProperty(value = "生效状态（0：有效，1：无效）", example = "测试生效状态（0：有效，1：无效）001")
    private int deleteFlag;
	/**
	 * 是否发送成功（SP接收：0:成功，非0:其他）
	 */
    @ApiModelProperty(value = "是否发送成功（SP接收：0:成功，非0:其他）", example = "测试是否发送成功（SP接收：0:成功，非0:其他）001")
    private String successCode;
	/**
	 * 是否推送成功（接口调用：0:成功，非0:其他）
	 */
    @ApiModelProperty(value = "是否推送成功（接口调用：0:成功，非0:其他）", example = "测试是否推送成功（接口调用：0:成功，非0:其他）001")
    private String apiPushCode;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间", example = "2018-08-08")
    private Date createTime;
}
