package string.leet_code_884;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/30 23:08
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/solution/bian-cheng-xiong-ha-xi-biao-acmjin-pai-t-ok6w/
 */
public class UncommonFromSentences2 {
    public static void main(String[] args) {
        UncommonFromSentences2 uncommonFromSentences = new UncommonFromSentences2();
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        String[] result = uncommonFromSentences.uncommonFromSentences(s1, s2);
        System.err.println("result : " + Arrays.toString(result));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        // 单词，出现的数量
        Map<String, Integer> freq = new HashMap<>();
        for (String s : arr1) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        for (String s : arr2) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        List<String> res = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }

        // list to array
        return res.toArray(new String[0]);

    }
}
