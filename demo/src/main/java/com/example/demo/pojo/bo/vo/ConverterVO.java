package com.example.demo.pojo.bo.vo;


import com.example.demo.util.BeanCopierUtil;

/**
 * @Description:转换成vo类接口
 */
public interface ConverterVO {

	/**
	 * 转换成vo对象
	 * 
	 * @param cls 目标对象class
	 * @return 目标对象实例
	 */
	default <T extends BaseVO> T toVO(Class<T> cls) {
		return BeanCopierUtil.copy(this, cls);
	}
}
