package math.appear_n_time.offer_56_2;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/12 16:33
 * @Desc : https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class SingleNumber {
    /**
     * 本算法同样适用于数组nums中存在负数的情况
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {//
        if (nums.length == 0){
            return -1;
        }

        //java int类型有32位，其中首位为符号位
        int[] bitSum = new int[32];
        int res = 0;
        for (int num : nums) {
            //需要在这里初始化，不能和res一起初始化
            int bitMask = 1;
            //bitSum[0]为符号位
            for (int i = 31; i >= 0; i--) {
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if ((num & bitMask) != 0){
                    //这里判断条件也可以写为(num&bitMask)==bitMask,而不是==1
                    bitSum[i]++;
                }
                bitMask = bitMask << 1;//左移没有无符号、带符号的区别，都是在右侧补0
            }
        }

        //这种做法使得本算法同样适用于负数的情况
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res += bitSum[i] % 3;// 这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;


    }

}
