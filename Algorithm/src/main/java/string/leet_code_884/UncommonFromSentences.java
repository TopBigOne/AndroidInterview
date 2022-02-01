package string.leet_code_884;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/30 18:02
 * @Url : https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 * @Level :  easy
 * @Desc : 两句话中的不常见单词
 * @Counter :
 * @Answer :
 */
public class UncommonFromSentences {
    public static void main(String[] args) {
        UncommonFromSentences sentences = new UncommonFromSentences();
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String[] result = sentences.uncommonFromSentences(s1, s2);
        System.out.println("result: " + Arrays.toString(result));

    }

    /**
     * 错误的解法
     * @param s1
     * @param s2
     * @return
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        String space = " ";
        String[] strArray1 = s1.split(space);
        String[] strArray2 = s2.split(space);
        List<String> list1 = Arrays.asList(strArray1);
        List<String> temp = new ArrayList<>();
        for (String s : strArray2) {
            if (!list1.contains(s)) {
                temp.add(s);
            }
        }

        List<String> list2 = Arrays.asList(strArray2);
        for (String s : strArray1) {
            if (!list2.contains(s)) {
                temp.add(s);
            }
        }
        return temp.toArray(new String[0]);
    }
}
