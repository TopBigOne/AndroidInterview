package dynamic_programming.opt_salary;

/**
 * @author : dev
 * @version :
 * @Date :  1/24/21 12:56 AM
 * @Desc : 测试最多薪资
 */
public class Test {
    public static void main(String[] args) {
        int[] startTime = {1, 3, 0, 4, 3, 5, 6, 8};
        int[] overTime = {4, 5, 6, 7, 8, 9, 10, 11};

        int[] salaries = {5, 1, 8, 4, 6, 3, 2, 4};

        OptSalary optSalary = new OptSalary();
        int maxSalary = optSalary.maxSalary6(startTime, overTime, salaries);
        System.out.println("maxSalary : " + maxSalary);

    }
}
