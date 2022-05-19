package string.one_edit_away;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/13 17:16
 * @Desc :
 */
public class Base {
    public void delete(OneEditAway oneEditAway) {
        System.out.println("测试删除一个字符 ：");
        String first = "teacher";
        String second = "taches";
        calculate(oneEditAway, first, second);
    }

    public void insert(OneEditAway oneEditAway) {
        System.out.println("测试插入一个字符：");
        String first = "teacher";
        String second = "taches";
        calculate(oneEditAway, first, second);
    }

    public void replace(OneEditAway oneEditAway) {
        System.out.println("测试替换一个字符：");

        // "teacher"
        //"taches"
        String first = "teacher";
        String second = "taches";
        calculate(oneEditAway, first, second);
    }

    private void calculate(OneEditAway oneEditAway, String first, String second) {
        boolean result = oneEditAway.oneEditAway(first, second);
        System.out.println("first  : " + first);
        System.out.println("second : " + second);
        System.out.println("result : " + result);
    }

}
