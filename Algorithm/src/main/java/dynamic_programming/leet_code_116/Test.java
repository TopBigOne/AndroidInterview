package dynamic_programming.leet_code_116;


import dynamic_programming.leet_code_114.UniquePaths;

/**
 * @author : dev
 * @version :
 * @Date :  1/18/ 1:37 AM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int A[] = {2, 3, 1, 1, 4};
        JumoGame jumoGame = new JumoGame();
        boolean result = jumoGame.canJump(A);
        System.out.println("result : " + result);
    }
}
