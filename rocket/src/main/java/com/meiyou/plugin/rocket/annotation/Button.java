package com.meiyou.plugin.rocket.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 提供按钮功能
 * It is used to add button the settings menu
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Button {
}
