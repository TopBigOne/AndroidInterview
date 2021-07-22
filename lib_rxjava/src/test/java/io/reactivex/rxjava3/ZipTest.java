package io.reactivex.rxjava3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import org.junit.Test;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/12 19:01
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ZipTest {
    @Test
    public void testZipOne(){
        Observable<String> o1 = Observable.just("a", "b", "c", "d", "e", "f");
        Observable<Integer> o2 = Observable.just(1, 2, 3,4);

        Observable<String> result = Observable.zip(o1, o2, new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) throws Throwable {
                return s+integer;
            }
        });

        result.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                System.out.println("result : "+s);
            }
        });

    }

}
