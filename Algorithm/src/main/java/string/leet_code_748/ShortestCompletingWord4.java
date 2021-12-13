package string.leet_code_748;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/10 21:50
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ShortestCompletingWord4 {

    int[] lcnt = new int[26];

    public String shortestCompletingWord(String licensePlate, String[] words) {
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
