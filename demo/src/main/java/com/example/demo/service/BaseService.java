package com.example.demo.service;



import com.example.demo.pojo.bo.IEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description: Service基类
 */
public interface BaseService<T extends IEntity> {

	/**
	 * 新增实例
	 * 
	 * @param record 业务实例
	 * @return 实例
	 */
	T add(@NotNull(message = "数据不能为空") T record);

	/**
	 * 修改实例
	 * 
	 * @param record 业务实例
	 * @return 实例
	 */
	T update(@NotNull(message = "数据不能为空") T record);

	/**
	 * 根据ID删除实例
	 * 
	 * @param id 数据id
	 * @return 成功返回true，否则返回false
	 */
	boolean delete(@NotEmpty(message = "数据id不能为空") String id);

	/**
	 * 根据ID数组批量删除实例
	 * 
	 * @param ids 数据id
	 * @return 成功返回true，否则返回false
	 */
	boolean delete(@NotNull(message = "数据id不能为空") String[] ids);

	/**
	 * 根据id获取实例数据
	 * 
	 * @param id 数据id
	 * @return 实例
	 */
	T get(@NotEmpty(message = "数据id不能为空") String id);
}
