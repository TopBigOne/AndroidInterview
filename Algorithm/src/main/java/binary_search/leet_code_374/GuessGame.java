package binary_search.leet_code_374;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/30 00:28
 * @Desc :
 */
public class GuessGame {

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     */
    int guess(int num) {

        return -1;

    }

    int guess(int pick, int target) {
        if (pick < target) {
            return -1;
        }
        if (pick > target) {
            return 1;
        }
        return 0;
    }
}

