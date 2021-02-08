package ten_sort.lock;

/**
 * @author : dev
 * @version :
 * @Date :  2/7/21 5:41 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        TempLock tempLock =new TempLock();
        int result = tempLock.tt(6);
        System.out.println("result:"+result);

    }
}
