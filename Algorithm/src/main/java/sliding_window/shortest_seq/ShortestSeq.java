package sliding_window.shortest_seq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 16:50
 * @Desc :
 */
public class ShortestSeq {
    public static void main(String[] args) {
        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = {1, 5, 9};

        ShortestSeq shortestSeq = new ShortestSeq();
        int[] result = shortestSeq.shortestSeq(big, small);
        System.err.println("result : " + Arrays.toString(result));
        for (int i = result[0]; i <= result[1]; i++) {
            System.err.println("--->" + big[i]);
        }
    }

    public int[] shortestSeq(int[] big, int[] small) {
        int bLength = big.length;
        int sLength = small.length;
        if (bLength < sLength) {
            return new int[0];
        }

        Map<Integer, Integer> window = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        int count = 0;
        int start = 0;
        int end = 0;
        int minLength = bLength + 1;
        int[] res = new int[]{-1, -1};
        for (int i : small) {
            need.put(i, need.getOrDefault(i, 0) + 1);
        }

        while (end < bLength) {

            int curr = big[end];

            window.put(curr, window.getOrDefault(curr, 0) + 1);

            if (need.containsKey(curr) && need.get(curr) > 0 && window.get(curr) <= need.get(curr)) {
                count++;
            }
            while (count == sLength) {
                int startValue = big[start];
                if (need.containsKey(startValue) && need.get(startValue) > 0 && window.get(startValue) <= need.get(startValue)) {
                    count--;
                }
                int temp = end - start + 1;
                if (temp < minLength) {
                    minLength = temp;
                    System.out.println(" 筱雅....");
                    res[0] = start;
                    res[1] = end;
                }

                start++;
                int tempCount = window.get(startValue) - 1;
                window.put(startValue, tempCount);
            }

            end++;
        }
        if (res[0] == -1) {
            return new int[0];
        }
        return res;


    }
}
