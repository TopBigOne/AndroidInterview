package dynamic_programming.leet_code_322;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  1/28/21 11:49 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange.coinChange9(coins, amount);
        System.out.println("result : " + result);

    }

}
