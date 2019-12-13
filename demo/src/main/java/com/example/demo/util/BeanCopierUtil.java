package com.example.demo.util;


import com.example.demo.pojo.bo.IEntity;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 对象属性复制辅助类
 */
public class BeanCopierUtil {

	/**
	 * 以String为Key存放BeanCopier对象HashMap集合
	 */
	private static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

	/**
	 * 对象属性复制
	 * 
	 * @param source 资源对象
	 * @param target 目标对象类
	 */
	public static void copy(Object source, Object target) {
		if (source == null || target == null) {
			return;
		}
		String beanKey = generateKey(source.getClass(), target.getClass());
		if (!beanCopierMap.containsKey(beanKey)) {
			BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), true);
			beanCopierMap.put(beanKey, beanCopier);
		}
		beanCopierMap.get(beanKey).copy(source, target, new BeanConverter());
	}

	/**
	 * 对象属性复制
	 * 
	 * @param source    资源对象
	 * @param targetCls 目标对象类
	 */
	public static <T> T copy(Object source, Class<T> targetCls) {
		if (source == null || targetCls == null) {
			return null;
		}
		try {
			T target = targetCls.newInstance();
			copy(source, target);
			return target;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成唯一key
	 * 
	 * @param sourceCls 资源类
	 * @param targetCls 目标类
	 * @return 资源类路径名称 + "_" + 目标类路径名称
	 */
	private static String generateKey(Class<?> sourceCls, Class<?> targetCls) {
		return sourceCls.getName() + "_" + targetCls.getName();
	}

	/**
	 * @Description: 属性转换
	 */
	private static class BeanConverter implements Converter {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Object convert(Object arg0, Class arg1, Object arg2) {
			if (arg0 != null && IEntity.class.isAssignableFrom(arg0.getClass()) && IEntity.class.isAssignableFrom(arg1)) {
				return copy(arg0, arg1);
			} else {
				return arg0;
			}
		}
	}
}
