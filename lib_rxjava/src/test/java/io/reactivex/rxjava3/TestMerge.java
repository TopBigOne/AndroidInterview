package io.reactivex.rxjava3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/12 18:35
 * @Url :
 * @Level :
 * @Desc :  merge-交叉合并,  组合多个被观察者一起发送数据，合并后 按时间线并行执行
 * @Counter :
 * @Answer :
 */
public class TestMerge {
    @Test
    public void mergeOne() {
        System.out.println("merge-交叉合并1:");
        Observable.merge(Observable.just(1, 2, 7, 8), Observable.just(3, 4, 5))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        System.out.println("result : " + integer);
                    }
                });

    }

    /**
     * 通过合并它们的排放将多个 Observables 组合成一个
     */
    @Test
    public void mergeTwo() {
        System.out.println("mergeTwo-交叉合并:");
        Observable.merge(
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS), // 从0开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS)) // 从2开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Throwable {

                    }
                });
    }
/**
     * 通过合并它们的排放将多个 Observables 组合成一个
     */
    @Test
    public void mergeThree() {
        System.out.println("mergeThree-交叉合并:");

        Observable.merge(//从事件0开始接收，事件数量为3，延迟1秒执行，间隔为3秒
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                //从事件10开始接收，事件数量为3，延迟1秒执行，间隔为3秒
                Observable.intervalRange(10, 3, 1, 1, TimeUnit.SECONDS)

        ).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Throwable {
                System.out.println("result: " + aLong);

            }
        });
    }


}
