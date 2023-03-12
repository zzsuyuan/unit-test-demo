package com.noob.ut.support


import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo


class MyDbUnitExtension extends AbstractAnnotationDrivenExtension<MyDbUnit> {

    @Override
    void visitFeatureAnnotation(MyDbUnit annotation, FeatureInfo feature) {
        def interceptor = new com.noob.ut.support.MyDbUnitInterceptor(annotation)
        feature.spec.addSetupSpecInterceptor(interceptor)
        feature.spec.addSetupInterceptor(interceptor)
        feature.featureMethod.addInterceptor(interceptor)
        feature.spec.addCleanupInterceptor(interceptor)
    }

}
