package com.meiyou.plugin.rocket.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 提供UI的名字
 * It is used to provide a title for the settings
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Title {

  String value();
}
