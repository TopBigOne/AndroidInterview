package array.leet_code_54;

/**
 * @author : dev
 * @version :
 * @Date :  7/4/21 7:51 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
        };

        SpiralOrder spiralOrder = new SpiralOrder();
        spiralOrder.spiralOrder3(matrix);
    }
}
