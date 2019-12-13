package com.example.demo.pojo.bo;


import com.example.demo.util.BeanCopierUtil;

/**
 * @Description: 转换成BO类接口
 */
public interface ConverterBO {

	/**
	 * 转换成bo对象
	 * 
	 * @param cls 目标对象class
	 * @return 目标对象实例
	 */
	default <T extends BaseBO> T toBO(Class<T> cls) {
		return BeanCopierUtil.copy(this, cls);
	};
}
