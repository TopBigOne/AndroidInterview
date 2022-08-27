package test;

import java.util.Scanner;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 19:10
 * @Desc :
 */
public class MinStep {
    /**
     * 最小步整数
     */
    public void minStep() {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("\\s+");
        int startNum = Integer.parseInt(split[0]);
        int tempStepMax = (split.length) >>> 1;
        int minSteps = -1;
        int length = split.length;

        if (length - startNum == 0) {
            minSteps = 1;
        } else {
            for (int i = 1; i < tempStepMax; i++) {
                int num = Integer.parseInt(split[i]);
                if (i + 1 + num == length) {
                    minSteps = 2;
                }
            }
        }
        System.out.print(minSteps);
    }
}
