package string.leet_code_748;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/10 21:39
 * @Url : https://leetcode-cn.com/problems/shortest-completing-word/submissions/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ShortestCompletingWord2 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] lcnt = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char currChar = licensePlate.charAt(i);
            if (Character.isLetter(currChar)) {
                lcnt[Character.toLowerCase(currChar) - 'a']++;
            }
        }

        String ans = null;
        for (String word : words) {
            if (check(word, lcnt) && (ans == null || ans.length() > word.length())) {
                ans = word;
            }
        }
        return ans;
    }

    private boolean check(String word, int[] lcnt) {
        int[] wcnt = new int[26];
        for (int i = 0; i < word.length(); i++) {
            wcnt[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (lcnt[i] > wcnt[i]) {
                return false;
            }
        }

        return true;
    }


}
