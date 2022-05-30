package math.leet_code_338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/23 16:17
 * @Desc :
 */
public class CountBits {
    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        int[] result = countBits.countBits(5);
        System.out.println(Arrays.toString(result));

    }

    public int[] countBits(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                count += (temp & 1);
                temp >>>= 1;
            }

            result.add(count);
        }

        return result.stream().mapToInt(a -> a).toArray();

    }
}
