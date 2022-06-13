package packsack.leet_code_416;

/**
 * @author : dev
 * @version :
 * @Date :  2/1/21 11:41 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[] raws = {1, 5, 11, 5};
        CanPartition partition = new CanPartition();
        boolean result = partition.canPartition9(raws);
        System.out.println("result :" + result);
    }
}
