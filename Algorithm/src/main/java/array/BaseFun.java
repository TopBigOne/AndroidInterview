package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/28 21:53
 * @Desc :
 */
public class BaseFun {
    public void divide(){
        System.out.println("============================================");
    }

    public void printRawArr(int[] raw){
        System.out.println(Arrays.toString(raw));
    }

    public static int[] generateArray(int... a) {
        List<Integer> res = new ArrayList<>();
        for (int i : a) {
            res.add(i);
        }

        return res.stream().mapToInt(v -> v).toArray();
    }



}
