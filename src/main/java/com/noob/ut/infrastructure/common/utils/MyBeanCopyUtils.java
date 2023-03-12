package com.noob.ut.infrastructure.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 对象拷贝工具类
 */
public class MyBeanCopyUtils extends BeanUtils {

    /**
     * 对象数据的拷贝
     *
     * @param source  数据源类
     * @param target  目标类::new (eg: UserVO::new)
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> T copyProperties(S source, Supplier<T> target) {
        return copyProperties(source, target, (BeanCopyUtilCallBack<S, T>) null);
    }

    /**
     * 带回调函数的对象数据的拷贝（可自定义字段拷贝规则）
     *
     * @param source  数据源类
     * @param target  目标类::new (eg: UserVO::new)
     * @param callBack 回调函数
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> T copyProperties(S source, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
        T t = target.get();
        copyProperties(source, t);
        if (callBack != null) {
            callBack.callBack(source, t,0);
        }
        return t;
    }

    /**
     * 集合数据的拷贝
     *
     * @param sources 数据源类
     * @param target  目标类::new (eg: UserVO::new)
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }

    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     *
     * @param sources  数据源类
     * @param target   目标类::new (eg: UserVO::new)
     * @param callBack 回调函数
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (int i = 0; i < sources.size(); i++) {
            S source = sources.get(i);
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null) {
                callBack.callBack(source, t,i);
            }
        }
        return list;
    }

    /**
     * 对象拷贝回调
     * @param <S>
     * @param <T>
     */
    @FunctionalInterface
    public interface BeanCopyUtilCallBack<S, T> {
        /**
         * 定义默认回调方法
         * @param source
         * @param target
         */
        void callBack(S source, T target, int idx);
    }

}