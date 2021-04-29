package array.leet_code_88;

import array.BaseFun;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/28 21:44
 * @Desc :
 */
public class TestIndex extends BaseFun {
    public static void main(String[] args) {
        TestIndex testIndex = new TestIndex();
        testIndex.doTest();
    }
    private void doTest() {
        divide();
        test1();
        divide();
        test2();
    }

    private void test1() {
        int index = 0;
        int[] arr = {4, 6, 8, 2, 8};
        printRawArr(arr);
        System.out.println("arr index:  before : " + index);
        System.out.println("arr[++index]       : " + (arr[++index]));
        System.out.println("arr index:  after  : " + index);
    }

    private void test2() {
        int index = 0;
        int[] arr = {4, 6, 8, 2, 8};
        printRawArr(arr);
        System.out.println("arr index:  before : " + index);
        System.out.println("arr[index++]       : " + (arr[index++]));
        System.out.println("arr index:  after  : " + index);
    }


}
