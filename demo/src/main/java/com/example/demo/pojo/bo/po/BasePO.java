package com.example.demo.pojo.bo.po;



import com.example.demo.pojo.bo.IEntityAspect;

import java.util.Date;

/**
 * @Description: 数据持久基类
 */
public class BasePO implements IEntityAspect {

	/** 数据ID */
	private String id;
	/** 数据状态,0正常,1回收,2删除 */
	private Integer sourcesState;
	/** 创建时间 */
	private Date createTime;
	/** 创建人用户名 */
	private String createUser;
	/** 更新时间 */
	private Date updateTime;
	/** 更新人用户名 */
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

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public Integer getSourcesState() {
		return sourcesState;
	}

	public void setSourcesState(Integer sourcesState) {
		this.sourcesState = sourcesState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	@Override
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	@Override
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
