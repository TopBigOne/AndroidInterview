package string.leet_code_383;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/4 22:37
 * @Url :https://leetcode-cn.com/problems/ransom-note/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class CanConstruct {
    public static void main(String[] args) {
        String a = "aa";
        String b = "aba";
        CanConstruct canConstruct = new CanConstruct();
        boolean result = canConstruct.canConstruct(a, b);
        System.out.println("result:" + result);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] tempOne = new int[256];
        int[] tempTwo = new int[256];
        for (int i = 0; i < ransomNote.length(); i++) {
            tempOne[ransomNote.charAt(i)]++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            tempTwo[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char currChar = ransomNote.charAt(i);
            System.out.println("currChar: " + currChar);
            if (tempOne[currChar] > tempTwo[currChar]) {
                return false;
            }
        }
        return true;
    }

}
