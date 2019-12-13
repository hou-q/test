package com.example.demo.pojo.bo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @Description: 基础业务对象
 */
@ApiModel
public class BaseBO implements VerifyInterface, IEntity {

	/** 数据ID */
	@NotEmpty(message = "数据ID不能为空", groups = { Update.class })
	@ApiModelProperty("ID")
	private String id;
	/** 创建时间 */
	@ApiModelProperty("创建时间")
	private Date createTime;
	/** 创建人用户名 */
	@ApiModelProperty("创建人")
	private String createUser;
	/** 更新时间 */
	@ApiModelProperty("更新时间")
	private Date updateTime;
	/** 更新人用户名 */
	@ApiModelProperty("更新人")
	private String updateUser;

	/**
	 * 清空创建(用户、时间)和更新(用户、时间)
	 */
	public void clearCreateAndUpdateInfo() {
		this.createTime = null;
		this.createUser = null;
		this.updateTime = null;
		this.updateUser = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
