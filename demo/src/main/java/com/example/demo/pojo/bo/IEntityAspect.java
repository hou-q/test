package com.example.demo.pojo.bo;

import java.util.Date;

public interface IEntityAspect extends IEntity {

	void setId(String id);

	void setCreateTime(Date createTime);

	void setCreateUser(String createUser);

	void setUpdateTime(Date updateTime);

	void setUpdateUser(String updateUser);
}
