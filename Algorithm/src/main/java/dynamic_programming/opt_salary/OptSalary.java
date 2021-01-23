package dynamic_programming.opt_salary;

/**
 * @author : dev
 * @version :
 * @Date :  1/23/21 7:29 PM
 * @Desc : 最多薪资（https://www.youtube.com/watch?v=1BAsAgdx7Ac&list=PL3ac3R-lErw2mdRg6XmvhWlkRDM9dyDOg&index=7）
 */
public class OptSalary {
    /**
     * @param startTime 开始时间
     * @param overTime  结束时间
     * @param salaries  每一个时间段所对应的薪资
     * @return
     */
    public int maxSalary(int[] startTime, int[] overTime, int[] salaries) {
        // 状态转移方程
        // OPT[i] = max{true: salaries[i]+OPT[pre[i]],false:OPT[i-1]}
        int n = salaries.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (startTime[i] >= overTime[j] && i != j) {
                    max = j + 1;
                }
            }
            pre[i] = max;
        }

        int[] opts = new int[n + 1];
        opts[0] = 0;

        for (int i = 1; i <= n; i++) {
            int leftValue = opts[i - 1];
            int rightValue = salaries[i - 1] + opts[pre[i - 1]];
            System.out.println("leftValue  : "+leftValue);
            System.out.println("rightValue : "+rightValue);
            opts[i] = Math.max(leftValue, rightValue);
        }

        return opts[n];
    }


    public int maxSalary2(int[] startTime, int[] overTime, int[] salaries) {
        //状态转移方程：
        //OPT[i]=max{true:salaries[i]+OPT[pre(i)], false:OPT[i-1]}
        int n = salaries.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (startTime[i] >= overTime[j] && i != j) {
                    max = j + 1;
                }
            }
            pre[i] = max;
        }

        int[] opts = new int[n + 1];
        opts[0] = 0;

        for (int i = 1; i <= n; i++) {
            opts[i] = Math.max(opts[i - 1], salaries[i - 1] + opts[pre[i - 1]]);
        }

        return opts[n];
    }
}
