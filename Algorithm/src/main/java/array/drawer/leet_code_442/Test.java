package array.drawer.leet_code_442;


import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/15 12:57
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test {
    public static void main(String[] args) {


        int[] nums = {4, 1, 3, 2, 7, 8, 2, 3, 1};
        FindDuplicate findDuplicate = new FindDuplicate();

        System.out.println("original nums : "+ Arrays.toString(nums));
        List<Integer> result = findDuplicate.findDuplicates2(nums);
        System.out.println("nums : "+ Arrays.toString(nums));
        System.out.println("result : "+result);

    }
}
