package array;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/22 3:50 PM
 * @Desc :  学习：System.arraycopy
 * <p>
 * <p>
 * Object src：the source array. 源数组
 * int srcPos：starting position in the source array. 在源数组中，开始复制的位置
 * Object dest：the destination array. 目标数组
 * int destPos：starting position in the destination data. 在目标数组中，开始赋值的位置
 * int length：the number of array elements to be copied. 被复制的数组元素的数量
 */
public class ArraycopyDemo {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] b = new int[5];

        System.arraycopy(a, 2, b, 3, 2);

        System.out.println("result b :" + Arrays.toString(b));
    }

}
