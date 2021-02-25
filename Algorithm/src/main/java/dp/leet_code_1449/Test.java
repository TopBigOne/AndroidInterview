package dp.leet_code_1449;

/**
 * @author : dev
 * @version :
 * @Date :  2/8/21 11:35 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int  [] raw = {4,3,2,5,6,7,2,5,5};
        int target = 9;
        String result = largestNumber.largestNumber(raw, target);
        System.out.println("result:"+result);


    }
}
