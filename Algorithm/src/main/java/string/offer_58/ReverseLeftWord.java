package string.offer_58;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/25 15:00
 * @Desc :
 * k = 2
 * ab cdefg
 * cdefg ab
 * -----
 * k = 6
 * lrloseumgh
 * umghlrlose
 */
public class ReverseLeftWord {
    public static void main(String[] args) {
        ReverseLeftWord reverseLeftWord = new ReverseLeftWord();

        String s = "lrloseumgh";
        int k = 6;
        String result = reverseLeftWord.reverseLeftWords(s, k);
        System.out.println("reverse result : " + result);
        System.out.println("test result : " + ("umghlrlose".equals(result)));

    }

    /**
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        String tempOne = s.substring(0, n);
        String tempTwo = s.substring(n);
        return tempTwo + tempOne;
    }
}
