package dynamic_programming.opt_salary;

import java.util.Arrays;


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
        System.out.println("pre value:" + Arrays.toString(pre));
        int[] opts = new int[n + 1];
        opts[0] = 0;

        for (int i = 1; i <= n; i++) {
            int leftValue = opts[i - 1];
            int preValue = pre[i - 1];
            int rightValue = salaries[i - 1] + opts[preValue];
            System.out.println("leftValue  : " + leftValue);
            System.out.println("rightValue : " + rightValue);
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

    public int maxSalary3(int[] startTime,
                          int[] overTime, int[] salaries) {
        // 状态转移方程，
        // OPT [i] = max{true: salaries[i]+OPT[pre(i)],false:OPT[i-1]}
        int n = salaries.length;
        int[] pre = new int[n];
        // 做一个小分类，当执行任务 i 时，ta 上一个可行的任务是哪一个！
        // ps: 有点像冒泡排序啊！
        // 从 1 开始遍历，因为，第一个任务，没有前驱
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    continue;
                }
                // 当前任务的开始时间
                int curTaskStartTime = startTime[i];
                // 上一个任务的结束时间
                int preTaskOverTie = overTime[j];
                System.out.println(" curTaskStartTime :" + curTaskStartTime + "," +
                        " preTaskOverTie : " + preTaskOverTie);
                if (curTaskStartTime >= preTaskOverTie) {
                    max = j + 1;
                }
            }
            //pre 下标所对应的是任务列表中第几个任务；（从 1 开始数）
            pre[i] = max;
            System.out.println("======================\n");
        }

        // 边界情况，opts 的 size 是 9；
        // 最优数据集（挣钱最多）
        int[] opts = new int[n + 1];
        opts[0] = 0;
        // 遍历任务，从 i 开始！
        // Q：为什么数组的最后一个值，是最大的呢？
        for (int i = 1; i <= n; i++) {
            // 就是只做当前的 task，挣的钱。
            int falseValue = opts[i - 1];
            int currTaskSalary = salaries[i - 1];
            int preTask = pre[i - 1];
            // 做上一个任务挣的钱
            int preTaskSalary = opts[preTask];
            // 做当前的 task + 上一个 task，挣的钱
            int trueValue = currTaskSalary + preTaskSalary;
            System.out.println(" falseValue :" + falseValue + ", trueValue : " + trueValue);
            opts[i] = Math.max(falseValue, trueValue);
        }
        return opts[n];
    }

    public int maxSalary4(int[] startTime, int[] overTime, int[] salaries) {
        // 状态转移方程,true: 做，false: 不做；
        // OPT [i] = max{true: salaries[i]+opt[pre[i]],false: opt[i-1]};
        int n = salaries.length;

        // 前一个能做任务的数组，主要是为了当 opt[pre[i]] 使用；
        // 求取方式，当前任务的开始时间，要大于上一个任务的结束时间
        int[] pre = new int[n];
        for (int i = 1; i < n; i++) {
            // 任务下摆哦
            int rawTaskIndex = 0;
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    continue;
                }
                int curTaskStartTime = startTime[i];
                int preTaskOverTime = overTime[j];
                if (curTaskStartTime >= preTaskOverTime) {
                    rawTaskIndex = j + 1;
                }
            }
            pre[i] = rawTaskIndex;
        }
        System.out.println("执行当前任务时，可执行上一个任务的下标：" + Arrays.toString(pre));

        // 最优解数组
        int[] opts = new int[n + 1];
        // 初始化边界
        opts[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 1: 不选
            int falseValue = opts[i - 1];
            // 2: 选
            // 因为 i 是从 1 开始的，所以，要i-1;
            int currTaskSalary = salaries[i - 1];
            //上一个 task 的下标是多少？从 pre[]数据集中获取
            int preTaskIndex = pre[i - 1];
            // 已经缓存了，直接取用就可以了，（备忘录模式）
            int preTaskSalary = opts[preTaskIndex];
            int trueVlaue = currTaskSalary + preTaskSalary;
            opts[i] = Math.max(falseValue, trueVlaue);
        }
        return opts[n];
    }

    public int maxSalary5(int[] startTime, int[] overTime, int[] salaries) {
        // 1: calcalte the pre data,and store them in a array;
        int taskLength = startTime.length;
        int[] pre = new int[taskLength];
        for (int i = 1; i < taskLength; i++) {
            int rawTaskIndex = 0;
            for (int j = 0; j < taskLength; j++) {
                if (i < j) {
                    continue;
                }
                int curStartTaskTime = startTime[i];
                int preOverTaskTime = overTime[j];
                // 注意，要大约并等于
                if (curStartTaskTime >= preOverTaskTime) {
                    rawTaskIndex = j + 1;
                }
            }
            pre[i] = rawTaskIndex;
        }

        System.out.println("执行当前任务时，还能执行上一个任务的下标集合：" + Arrays.toString(pre));
        int[] opts = new int[taskLength + 1];
        opts[0] = 0;
        for (int i = 1; i <= taskLength; i++) {
            // 2: false: opt[i-1]
            int falseValue = opts[i - 1];
            // 3: true: vi+opt[pre[i-1]]:状态转移方程
            // 当前任务的薪水
            int curTaskSalary = salaries[i - 1];
            // 上一个任务的下标
            int preTaskIndex = pre[i - 1];
            // 上一个任务能赚到的薪水
            int preTaskSalary = opts[preTaskIndex];
            // 做当前任务和上一个任务一共能赚到的钱
            int trueValue = curTaskSalary + preTaskSalary;
            // 比较一下，取最大值；
            opts[i] = Math.max(falseValue, trueValue);
        }
        return opts[taskLength];

    }

    public int maxSalary6(int[] startTime, int[] overTime, int[] salaries) {
        int n = startTime.length;
        int[] pre = new int[n];
        for (int i = 1; i < n; i++) {
            int tempIndex = 0;
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    continue;
                }
                if (startTime[i] >= overTime[j]) {
                    tempIndex = j + 1;
                }
            }
            pre[i] = tempIndex;
        }

        System.out.println("pres[] :" + Arrays.toString(pre));
        int[] opts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            opts[i] = Math.max(opts[i - 1], salaries[i - 1] + opts[pre[i - 1]]);
        }
        opts[0] = 0;
        return opts[n];
    }


    public int maxSalary7(int[] startTime, int[] overTime, int[] salaries) {
        int n = startTime.length;
        int[] pre = new int[n];

        for (int i = 1; i < n; i++) {
            int maxIndex = 0;
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    continue;
                }
                // 注意，等于也是可以的；上一个任务的结束时间，就是下一个任务的结束时间；
                if (startTime[i] >= overTime[j]) {
                    maxIndex = j + 1;
                }
            }
            pre[i] = maxIndex;
        }

        System.out.println("做当前任务时，上一个可执行任务的数据集：" + Arrays.toString(pre));

        int[] opts = new int[n + 1];
        opts[0] = 0;
        for (int i = 1; i <= n; i++) {
            opts[i] = Math.max(opts[i - 1], salaries[i - 1] + opts[pre[i - 1]]);
        }

        return opts[n];


    }


}
