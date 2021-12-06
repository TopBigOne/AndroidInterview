package string.leet_code_1816;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/6 21:40
 * @Url : https://leetcode-cn.com/problems/truncate-sentence/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class TruncateSentence {
    public static void main(String[] args) {
        String s = "What is the solution to this problem";
        int k = 4;
        TruncateSentence truncateSentence = new TruncateSentence();
        String result = truncateSentence.truncateSentence(s, k);
        System.out.println("result : "+result);
    }

    /**
     * 自己的解答方式
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(str[i]).append(" ");
        }
        return sb.toString().trim();

    }
}
