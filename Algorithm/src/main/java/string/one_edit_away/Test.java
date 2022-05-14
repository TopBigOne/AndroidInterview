package string.one_edit_away;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/13 16:53
 * @Desc : 编辑距离，测试类
 */
public class Test {
    public static void main(String[] args) {
        OneEditAway oneEditAway = new OneEditAway();
        oneEditAway.insert(oneEditAway);
        oneEditAway.delete(oneEditAway);
        oneEditAway.replace(oneEditAway);
    }


}
