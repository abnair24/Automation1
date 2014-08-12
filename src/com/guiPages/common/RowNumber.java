package com.guiPages.common;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
public @interface RowNumber {
	 int rowNumber() default 0;
}
