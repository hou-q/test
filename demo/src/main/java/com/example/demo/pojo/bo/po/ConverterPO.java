package com.example.demo.pojo.bo.po;


import com.example.demo.util.BeanCopierUtil;

/**
 * @Description: 转换成po类接口
 */
public interface ConverterPO {

	/**
	 * 转换成po对象
	 * 
	 * @param cls 目标对象class
	 * @return 目标对象实例
	 */
	default <T extends BasePO> T toPO(Class<T> cls) {
		return BeanCopierUtil.copy(this, cls);
	};
}
