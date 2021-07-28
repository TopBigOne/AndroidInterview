package dp.leet_code_354;

/**
 * @author : dev
 * @version :
 * @Date :  7/26/21 12:33 AM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {

        int[][] es = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        MaxEnvelope maxEnvelope = new MaxEnvelope();
        maxEnvelope.maxEnvelopes(es);
    }

}
