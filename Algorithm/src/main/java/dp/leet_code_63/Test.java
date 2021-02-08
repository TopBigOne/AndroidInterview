package dp.leet_code_63;



/**
 * @author : dev
 * @version :
 * @Date :  1/26/21 11:42 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int[][] raw = {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0},
                        {0, 0, 0}};
        int result = uniquePathsWithObstacles.uniquePathWithObstacles13(raw);
        System.out.println("result : " + result);
    }
}
