package packsack.leet_code_139;

import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/10 19:43
 * @Desc :
 */
public class WordBreak3 extends Base {
    public static void main(String[] args) {
        //  "leetcode"
        //        ["leet","code"]
        WordBreak3 wordBreak = new WordBreak3();
        List<String> stringList = wordBreak.listOne();
        String s = "leetcode";
        boolean result = wordBreak.wordBreak(s, stringList);
        System.err.println("result : " + result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : wordDict) {
            sb.append(s1);


            if (s.contains(sb.toString())) {
                return true;
            }
        }
        return false;

    }

}
