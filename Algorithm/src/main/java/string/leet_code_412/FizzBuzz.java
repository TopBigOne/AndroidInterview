package string.leet_code_412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/26 01:37
 * @Desc :
 */
public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> strings = fizzBuzz.fizzBuzz(3);
        System.err.println("strings : "+strings);

    }

    /**
     * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
     * answer[i] == "Fizz" 如果 i 是 3 的倍数。
     * answer[i] == "Buzz" 如果 i 是 5 的倍数。
     * answer[i] == i （以字符串形式）如果上述条件全不满足。
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                res.add("Fizz");
                continue;

            }
            if (i % 5 == 0) {
                res.add("Buzz");
                continue;

            }
            res.add(String.valueOf(i));
        }
        return res;


    }
}
