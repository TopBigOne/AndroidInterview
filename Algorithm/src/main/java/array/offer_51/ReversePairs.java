package array.offer_51;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/3 17:11
 * @Url : https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @Level : easy medium hard
 * @Desc :数组中的逆序对 和这个题一样：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/
 * @Counter :  9
 * @Answer :  照着归并排序的思路就能写出来。
 *
 * 1： 暴力解法(超时)
 * 2：分治思想
 * 3：树壮数组(这是一个经典做法)
 */
public class ReversePairs {
    public int  reversePairs(int [] nums){
        int len = nums.length;
        if (len<2){
            return 0;
        }
        // 离散化，是数字更紧凑，节约树状


        return 0;


    }


}
