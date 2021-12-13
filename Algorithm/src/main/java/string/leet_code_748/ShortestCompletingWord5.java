package string.leet_code_748;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/10 22:00
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ShortestCompletingWord5 {

    int[] lcnt = new int[26];

    public String shortestCompletingWord(String licensePlate, String[] words) {
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                int index = Character.toLowerCase(c) - 'a';
                lcnt[index]++;
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
            if (lcnt[i] > wcnt[i]) {
                return false;
            }
        }


        for (int i = 0; i < 26; i++) {
            if(lcnt[i]>wcnt[i]){
                return false;
            }

        }
        return true;
    }


}
