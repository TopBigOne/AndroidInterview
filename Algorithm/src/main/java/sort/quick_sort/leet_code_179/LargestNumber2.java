package sort.quick_sort.leet_code_179;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 13:28
 * @Desc :
 */
public class LargestNumber2 {

    public String largestNumber(int[] nums) {
        ArrayList<String> stringList = new ArrayList<>();
        for (int num : nums) {
            stringList.add(String.valueOf(num));
        }
        stringList.sort((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });
        if (stringList.get(0).startsWith("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stringList) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String largestNumber2(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int num : nums) {
            res.add(String.valueOf(num));
        }

        res.sort((a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);

        });
        if (res.get(0).startsWith("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String re : res) {
            sb.append(re);
        }
        return sb.toString();


    }
}
