package com.jar.pattern.state.base;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/11 15:28
 * @Url :
 * @Level :  easy
 * @Desc : 所有的状态，都必须实现这个接口
 * @Counter :
 * @Answer :
 */
public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    /*
     * 分发
     */
    void dispense();

    void refill();
}
