package com.w2a.architectbatch1.customAnnotation;

import java.lang.annotation.*;  
import java.lang.reflect.*;  

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
public @interface TestCaseId {
	String testCaseId();
	

}
