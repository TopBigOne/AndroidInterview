package dynamic_programming.leet_code_139;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  1/28/21 1:07 AM
 * @Desc : https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-ju-jue-zhuang-xcong-jian-dan-de-xi/
 */
public class Test {
    public static void main(String[] args) {

        String s = "leetcode";

        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak14(s, wordDict);
        System.out.println("result : " + result);
    }


}
