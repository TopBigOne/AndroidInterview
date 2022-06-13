package math.offer_15;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/9 20:13
 * @Desc :
 */
public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        int result = hammingWeight.hammingWeight(11);
        System.err.println("result : " + result);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res += 1;
            }
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;

    }
}
