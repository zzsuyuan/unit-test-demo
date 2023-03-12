package com.noob.ut.support


import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtensionAnnotation(com.noob.ut.support.MyDbUnitExtension.class)
@interface MyDbUnit {

    String xmlLocation() default "";

    String schema() default "";

}


