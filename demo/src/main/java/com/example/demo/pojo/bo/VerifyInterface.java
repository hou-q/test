package com.example.demo.pojo.bo;



import com.example.demo.common.ErrorCodeEm;
import com.example.demo.common.VerifyException;
import com.example.demo.util.CollectionUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 校验接口
 */
public interface VerifyInterface {

	/**
	 * 验证BO对象
	 * 
	 * @param type 验证分组枚举对象
	 * @return Map<String, String>对象
	 */
	default Map<String, String> validator(VerifyType type) {
		if (type == null) {
			throw new VerifyException(ErrorCodeEm.parameterError.getMsg(), ErrorCodeEm.parameterError.getCode());
		}
		Map<String, String> errors = new HashMap<String, String>();
		Validator validator = ValidatorFactory.getValidator();
		Set<ConstraintViolation<VerifyInterface>> violations = validator.validate(this, Default.class, type.getCls());
		if (!CollectionUtil.isEmpty(violations)) {
			violations.forEach(violation -> errors.put(violation.getPropertyPath().toString(), violation.getMessage()));
		}
		return errors;
	}

	/**
	 * @Description:验证分组枚举
	 */
	public static enum VerifyType {
		add, update;

		public Class<?> getCls() {
			switch (this) {
			case add:
				return Add.class;
			case update:
				return Update.class;
			default:
				return null;
			}
		}
	}

	/**
	 * @Description: 新增验证分组
	 */
	public interface Add {
	}

	/**
	 * @Description: 修改验证分组
	 */
	public interface Update {
	}

	/**
	 * @Description: 关联验证分组
	 */
	public interface Association {
	}

	/**
	 * @Description: 验证器类
	 */
	public static class ValidatorFactory {

		private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		/**
		 * 获取验证器实例
		 */
		public static Validator getValidator() {
			return validator;
		}
	}
}
