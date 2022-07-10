package interval.leet_code_763;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/10 06:16
 * @Desc : 763. 划分字母区间 ： https://leetcode.cn/problems/partition-labels/
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段
 * ，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * ----------
 * 示例：：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 题解：https://leetcode.cn/problems/partition-labels/solution/763-hua-fen-zi-mu-qu-jian-ji-lu-zui-yuan-wei-zhi-y/
 */
public class PartitionLabel {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        PartitionLabel partitionLabel = new PartitionLabel();
        List<Integer> result = partitionLabel.partitionLabels(S);
        System.err.println("S      : " + S);
        System.err.println("result : " + result);
    }

    public List<Integer> partitionLabels(String s) {
        // 所有字符的最大下标
        int[] allIndex = new int[128];
        for (int i = 0; i < s.length(); i++) {
            allIndex[s.charAt(i)] = i;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            // 当前字符的最大下标
            right = Math.max(right, allIndex[currChar]);
            // 遍历到最大下标位置
            // 可以做长度截取
            if (i == right) {
                res.add(right - left + 1);
                // 更新left 下标位置，便于下次做截取
                left = i + 1;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels2(String s) {
        int[] allIndex = new int[128];
        for (int i = 0; i < s.length(); i++) {
            allIndex[s.charAt(i)] = i;
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(allIndex[s.charAt(i)], right);
            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }

    public List<Integer> partitionLabels3(String s) {
        int[] allIndex = new int[128];
        for (int i = 0; i < s.length(); i++) {
            allIndex[s.charAt(i)] = i;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, allIndex[s.charAt(i)]);
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;

            }

        }
        return res;


    }
}
