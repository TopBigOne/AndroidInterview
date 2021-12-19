package math.leet_code_1518;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/17 00:25
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class NumWaterBottles {
    public static void main(String[] args) {
        NumWaterBottles numWaterBottles = new NumWaterBottles();
        int result = numWaterBottles.numWaterBottles(9, 3);
        System.out.println("result : " + result);

    }

    public int numWaterBottles(int numBottles, int numExchange) {
        //当前喝到的酒瓶数
        int cnt = numBottles;
        //当前剩下的空酒瓶数
        int rest = numBottles;
        //只要不小于给定的空酒瓶数就可以继续换新酒
        while (rest >= numExchange) {
            int newBottles = rest / numExchange;
            cnt += newBottles;
            int mod = rest % numExchange;
            rest = newBottles + mod;
        }
        return cnt;

    }

    public int numWaterBottles2(int numBottles, int numExchange) {
        int cnt = numBottles;
        int rest = numBottles;
        while (rest >= numExchange) {
            int newBottles = rest / numExchange;
            cnt += newBottles;
            int mod = rest % numExchange;
            rest = newBottles + mod;
        }

        return cnt;
    }

    public int numWaterBottles3(int numBottles, int numExchange) {
        int cnt = numBottles;
        int rest = numBottles;
        while (rest >= numExchange) {
            int newBottles = rest / numExchange;
            cnt += newBottles;
            int mod = rest % numExchange;
            rest = newBottles + mod;
        }
        return cnt;

    }

}

