package com.zhku.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息模板：所有类型都维护模板
 * @date 2019-09-05 17:09:54
 */
@TableName("tb_dsf_msg_template")
@ApiModel(description = "消息模板：所有类型都维护模板")
@Data
public class DsfMsgTemplatePO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
    @ApiModelProperty(value = "id", example = "1000001")
    @TableId
    private String id;
	/**
	 * 模板编码
	 */
	@ApiModelProperty(value = "模板编码", example = "模板编码01")
    private String messageCode;
	/**
	 * 模块名称
	 */
    @ApiModelProperty(value = "模块名称", example = "测试模块名称001")
    private String moduleName;
	/**
	 * 模板类型（tb_dsf_message_type.type_num）
	 */
    @ApiModelProperty(value = "模板类型（tb_dsf_message_type.type_num）", example = "测试模板类型（tb_dsf_message_type.type_num）001")
    private String moduleType;
	/**
	 * 消息类型（默认为 短信）
	 */
    @ApiModelProperty(value = "消息类型（默认为 短信）", example = "测试消息类型（默认为 短信）001")
    private String messageType;
	/**
	 * 消息内容
	 */
    @ApiModelProperty(value = "消息内容", example = "测试消息内容001")
    private String content;
	/**
	 * 描述
	 */
    @ApiModelProperty(value = "描述", example = "测试描述001")
    private String remarks;
	/**
	 * 模板状态（0：开启；1：关闭）
	 */
    @ApiModelProperty(value = "模板状态（0：开启；1：关闭）", example = "测试模板状态（0：开启；1：关闭）001")
    private String templateState;
	/**
	 * 过滤白名单（0：是；1：否）
	 */
    @ApiModelProperty(value = "过滤白名单（0：是；1：否）", example = "测试过滤白名单（0：是；1：否）001")
    private String filterWhite;
	/**
	 * 过滤黑名单（0：是；1：否）
	 */
    @ApiModelProperty(value = "过滤黑名单（0：是；1：否）", example = "测试过滤黑名单（0：是；1：否）001")
    private String filterBlack;
	/**
	 * 生效状态（0有效，1失效）
	 */
    @ApiModelProperty(value = "生效状态（0有效，1失效）", example = "true")
    private Boolean isDelete;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人", example = "测试创建人001")
    private String createUser;
	/**
	 * 创建人姓名
	 */
    @ApiModelProperty(value = "创建人姓名", example = "测试创建人姓名001")
    private String createName;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间", example = "2018-08-08")
    private Date createTime;
	/**
	 * 修改人
	 */
    @ApiModelProperty(value = "修改人", example = "测试修改人001")
    private String updateUser;
	/**
	 * 修改人姓名
	 */
    @ApiModelProperty(value = "修改人姓名", example = "测试修改人姓名001")
    private String updateName;
	/**
	 * 修改时间
	 */
    @ApiModelProperty(value = "修改时间", example = "2018-08-08")
    private Date updateTime;
}
