package array.leet_code_169;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/10 12:59
 * @Desc :
 */
public class MajorityElement3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        MajorityElement3 majorityElement = new MajorityElement3();
        int result = majorityElement.majorityElement(nums);
        System.err.println("result : " + result);
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }

            if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        int res = 0;
        int count = 0;
        for (int currNum : nums) {
            if (count == 0) {
                res = currNum;
            }
            if (res == currNum) {
                count++;
            } else {
                count--;
            }
        }


        return res;
    }

}
