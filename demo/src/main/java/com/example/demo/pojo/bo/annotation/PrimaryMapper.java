package com.example.demo.pojo.bo.annotation;

import java.lang.annotation.*;

/**
 * @Description:MyBatis 扫描加载标志
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface PrimaryMapper {
}
