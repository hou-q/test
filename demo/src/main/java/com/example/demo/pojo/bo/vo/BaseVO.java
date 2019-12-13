package com.example.demo.pojo.bo.vo;


import com.example.demo.pojo.bo.IEntity;

/**
 * @Description: 展示基类
 */
public class BaseVO implements IEntity {

	/** 数据ID */
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
