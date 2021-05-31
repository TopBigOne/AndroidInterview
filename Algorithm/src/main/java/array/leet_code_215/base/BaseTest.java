package array.leet_code_215.base;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 17:41
 * @Url :
 * @Level : easy medium hard
 * @Desc : 测试使用
 * @Counter :
 * @Answer :
 */
public class BaseTest {
    protected static int[] nums = {3, 2, 1, 5, 6, 4,8,7,9};
    protected static int k = 2;

    protected static void printResult(Object o) {
        if (o.getClass().isArray()) {
            System.out.println("result : " + Arrays.toString((Object[]) o));
            return;
        }
        System.out.println("result : " + o.toString());
    }

}
