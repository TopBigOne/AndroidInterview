package string.meituan;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/26 20:43
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String s = "think i have";
        ReverseSentence reverseSentence = new ReverseSentence();
        String result = reverseSentence.reverse(s);
        System.out.println(result);

    }

    public String reverse(String sentence) {
        String[] strs = sentence.split(" ");
        int left = 0;
        int right = strs.length - 1;
        while (left < right) {
            String temp = strs[left];
            strs[left] = strs[right];
            strs[right] = temp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }
}
