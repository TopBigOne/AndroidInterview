package io.reactivex.rxjava3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import org.junit.Test;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/12 18:38
 * @Url :
 * @Level :
 * @Desc : 顺序发出
 * @Counter :
 * @Answer :
 */
public class TestConcat {
    @Test
    public void concatOne() {
        System.out.println("concat 顺序发出 ");
        Disposable disposables = Observable.concat(Observable.just(1, 23, 465),
                Observable.just(789, 987, 666))
                .subscribe(integer -> System.out.println("result : " + integer));

        disposables.dispose();
    }

    @Test
    public void concatTwo() {

        System.out.println("测试2：concat 顺序发出 ");
        // concat（）：组合多个被观察者（≤4个）一起发送数据
        // 注：串行执行
        Disposable disposables = Observable.concat(Observable.just(1, 2, 3),
                Observable.just(4, 5, 6),
                Observable.just(7, 8, 9),
                Observable.just(10, 11, 12))
                .subscribe(integer -> System.out.println("integer : " + integer));
        disposables.dispose();

    }

    /**
     * 测试三
     */
    @Test
    public void concatThree() {
        System.out.println("测试3：concatArray  顺序发出 ");
        // concatArray（）：组合多个被观察者一起发送数据（可＞4个）
        // 注：串行执行
        Disposable disposables = Observable.concatArray(
                Observable.just(1, 2, 3),
                Observable.just(4, 5, 6),
                Observable.just(7, 8, 9),
                Observable.just(10, 11, 12),
                Observable.just(13, 14, 15))
                .subscribe(integer -> System.out.println("integer : " + integer));
        disposables.dispose();

    }


}
