package array.leet_code_26;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 3:33 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int[] raws = {2, 3, 3, 4, 4, 5, 6, 7, 7, 8};
        int result = removeDuplicate.removeDuplicate(raws);
        System.out.println("result : " + result);
    }
}
