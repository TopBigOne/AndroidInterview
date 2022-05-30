package array.leet_code_11;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/19 17:51
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};


        MaxArea maxArea = new MaxArea();
        int result = maxArea.maxArea4(nums);
        System.out.println("result: " + result);

    }
}
