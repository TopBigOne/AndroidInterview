package math.leet_code_470;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 14:10
 * @Desc : 470  用 Rand7() 实现 Rand10() https://leetcode.cn/problems/implement-rand10-using-rand7/
 * <p>
 * 1、题目给你一个等概率函数，你可以把他转换为一个等概率返回0和1的函数rand01();
 * 2、因为f()可以构造任何等概率的函数，以题目举例;
 * 3、已知等概率返回1-7,我们可以在rand01()循环中等于4重新计算，小于4返回0，大于4返回1。这是等概率的
 * 4、构造1-10等概率，可以先构造0-9等概率再加1。估算至少需要4个二进制位，相加即可。
 * PS:此类题以后先转换成等概率返回0和1
 *
 * https://leetcode.cn/problems/implement-rand10-using-rand7/solution/zhe-yi-lei-ti-de-tong-yong-fang-fa-bu-ka-cuqu/
 */
public class Rand2 extends SolBase {

    public int rand10() {
        int res;
        do {
            res = (rand01() << 3) + (rand01() << 2) + (rand01() << 1) + rand01();
        } while (res > 9);
        return res + 1;

    }

    public int rand01() {
        int res;
        do {
            res = rand7();
        } while (res == 4);
        return res < 4 ? 0 : 1;
    }


}
