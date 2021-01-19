package dynamic_programming.leet_code_669;

/**
 * @author : dev
 * @version :
 * @Date :  1/17/21 1:12 AM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] rawData = {2, 5, 7};
        int target = 27;
        int result = coinChange.coinChange(rawData, target);
        System.out.println("result :" + result);
    }
}
