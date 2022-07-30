package binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/30 15:08
 * @Desc :
 */
public class Base {
    public static int[] generateArray(int... a) {
        List<Integer> res = new ArrayList<>();
        for (int i : a) {
            res.add(i);
        }

        return res.stream().mapToInt(v -> v).toArray();
    }
}
