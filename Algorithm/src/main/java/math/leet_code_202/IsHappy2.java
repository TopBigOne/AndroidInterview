package math.leet_code_202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/19 12:08
 * @Desc : https://leetcode.cn/problems/happy-number/
 */
public class IsHappy2 {
    public static void main(String[] args) {
        IsHappy2 isHappy = new IsHappy2();
        boolean result = isHappy.isHappy(19);
        System.err.println("result : " + result);
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        List<Integer> recordList = new ArrayList<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += Math.pow(digit, 2);
                n /= 10;
            }

            recordList.add(sum);

            if (!set.add(sum)) {
                Collections.sort(recordList);
                System.err.println("recordList : " + recordList);
                return false;
            }
            n = sum;
        }
        Collections.sort(recordList);
        System.err.println("recordList : " + recordList);
        return true;
    }
}
