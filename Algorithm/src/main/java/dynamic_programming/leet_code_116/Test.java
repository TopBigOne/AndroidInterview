package dynamic_programming.leet_code_116;


/**
 * @author : dev
 * @version :
 * @Date :  1/18/ 1:37 AM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        JumpGame jumpGame = new JumpGame();
        boolean result = jumpGame.canJump(a);
        System.out.println("result : " + result);
    }
}
