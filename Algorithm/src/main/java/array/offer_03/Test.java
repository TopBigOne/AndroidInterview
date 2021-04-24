package array.offer_03;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/24 18:23
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int [] data = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        int repeatNumber = findRepeatNumber.findRepeatNumber(data);
        System.out.println(repeatNumber);
    }
}
