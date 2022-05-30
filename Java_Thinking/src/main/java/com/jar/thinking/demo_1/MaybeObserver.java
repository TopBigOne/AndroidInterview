package com.jar.thinking.demo_1;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 15:27
 * @Desc :
 */
public interface MaybeObserver<T> {

    /**
     * <? extends T> :  T 和T 的子类，规定了泛型类型的上限
     * NOTE: 适合 消费元素 场景
     *
     * @param observer
     */
    void subscribe(MaybeObserver<? extends T> observer);

    /**
     * <? super T> :  T 和T 的父类，规定了泛型类型的下限
     * NOTE: 适合 生产元素 场景
     *
     * @param observer
     */
    void subscribeTempOne(MaybeObserver<? super T> observer);

    /**
     * @param observer
     */
    void subscribeTWo(MaybeObserver<?> observer);


}
