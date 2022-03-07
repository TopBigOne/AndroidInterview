package sliding_window.leet_code_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/28 17:33
 * @Url : https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/
 * @Level :     hard
 * @Desc :
 * @Counter : barfoothefoobarman
 * @Answer :
 */
public class FindSubstring2 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();

        int sLength = s.length();

        if (sLength == 0 || words.length == 0) {
            return res;
        }

        for (String word : words) {
            // 主串s中没有这个单词，直接返回空
            if (!s.contains(word)) {
                return res;
            }
            // map中保存每个单词，和它出现的次数
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }


        // 每个单词的长度，
        int singleWordLen = words[0].length();
        //  总长度
        int allWordsLen = singleWordLen * words.length;

        // 主串s长度小于单词总和，返回空
        if (allWordsLen > sLength) {
            return res;
        }

        // 只讨论从0，1，...， singleWordLen-1 开始的子串情况，
        // 每次进行匹配的窗口大小为 allWordsLen，每次后移一个单词长度，由左右窗口维持当前窗口位置
        for (int i = 0; i < singleWordLen; i++) {
            // 左右窗口
            int left = i;
            int right = i;
            int count = 0;
            // 统计每个符合要求的word
            Map<String, Integer> subMap = new HashMap<>();

            // 右窗口不能超出主串长度
            while (right + singleWordLen <= sLength) {
                // 得到一个单词
                String currWord = s.substring(right, right + singleWordLen);

                // 窗口右移
                right += singleWordLen;
                // words[]中没有这个单词，那么当前窗口肯定匹配失败，直接右移到这个单词后面
                if (!wordsMap.containsKey(currWord)) {
                    left = right;
                    // 窗口内单词统计map清空，重新统计
                    subMap.clear();
                    // 符合要求的单词数清0
                    count = 0;
                    continue;
                }


                // 统计当前子串中这个单词出现的次数
                subMap.put(currWord, subMap.getOrDefault(currWord, 0) + 1);
                count++;
                // 如果这个单词出现的次数大于words[]中它对应的次数，又由于每次匹配和words长度相等的子串
                // 如 ["foo","bar","foo","the"]  "| foobarfoobar| foothe"
                // 第二个bar虽然是words[]中的单词，但是次数抄了，那么右移一个单词长度后 "|barfoobarfoo|the"
                // bar还是不符合，所以直接从这个不符合的bar之后开始匹配，也就是将这个不符合的bar和它之前的单词(串)全移出去
                while (subMap.getOrDefault(currWord, 0) > wordsMap.getOrDefault(currWord, 0)) {
                    // 从当前窗口字符统计map中删除从左窗口开始到数量超限的所有单词(次数减一)
                    String leftWord = s.substring(left, left + singleWordLen);
                    subMap.put(leftWord, subMap.getOrDefault(leftWord, 0) - 1);
                    // 符合的单词数减一
                    count--;
                    // 左窗口位置右移
                    left += singleWordLen;
                }

                // 当前窗口字符串满足要求
                if (count == words.length) {
                    res.add(left);
                }
            }
        }
        return res;

    }
}
