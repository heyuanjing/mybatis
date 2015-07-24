package com.mybatis.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cache.annotation.Cacheable;

/**
 * 
 * @description 自定义注解 
 *
 * @author heyuanjing
 * @version $Id: MyCacheable.java, v 0.1 2015年7月24日 上午11:39:37 heyuanjing Exp $
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Cacheable(value = "defaultCache")
public @interface MyCacheable {

}