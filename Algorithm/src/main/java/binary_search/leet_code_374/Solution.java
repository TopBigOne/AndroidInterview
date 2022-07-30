package binary_search.leet_code_374;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/30 00:29
 * @Desc :
 */
public class Solution extends GuessGame {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.guessNumber2(10, 6);
        System.err.println("result : " + result);
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int res = guess(mid);
            System.out.println("res : " + res);
            if (res == 0) {
                return mid;
            }
            if (res == -1) {
                l = mid + 1;
                continue;
            }
            if (res == 1) {
                r = mid - 1;
                continue;
            }
        }
        return -1;
    }

    public int guessNumber2(int n, int target) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int pick = (l + r) >> 1;
            int res = guess(pick, target);
            System.err.println("pick : " + pick);
            System.err.println("res : " + res);
            System.err.println("-----------------|");
            if (res == 0) {
                return pick;
            }
            // pick > pick
            if (res == -1) {
                l = pick + 1;
                continue;
            }
            if (res == 1) {
                r = pick - 1;
                continue;
            }
        }
        return -1;
    }

    public int guessNumber3(int n, int target) {

        return -1;
    }


}
