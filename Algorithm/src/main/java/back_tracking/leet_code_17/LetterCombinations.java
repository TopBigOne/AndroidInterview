package back_tracking.leet_code_17;


import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/19 23:18
 * @Url : https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : 题解：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
 */
public class LetterCombinations {

    // 一个映射表，第二个位置是"abc",
    // 用数组可以节省点内存
    String[] letterMap = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    /**
     * 回溯解法
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return res;

        }
        iterStr(digits,new StringBuilder(),0);
        return  res;
    }

    private void iterStr(String str,StringBuilder letter,int index){
        // 递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要做了点优化
        // 动态图中每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不好，
        // 但是用index 记录每次的位置，这样，性能好
        if(index ==str.length()){
            res.add(letter.toString());
            return;
        }
        // 获取index位置的字符，假设输入的字符是"234"
        // 第一次递归时，index为0 ，c=2,第二次index 为1 ，所以c=3，第三次c=4;
        // substring 每次都会生成新的字符串，而index则是去当前的一个字符，所以效率更高一些
        char c = str.charAt(index);
        // mapString 的下标是从0开始到9，c-'0' 就可以取到相对的数组的下标位置
        // 比如c=2 时候，2-'0' ,获取下标为2，letterMap[2] 就是abc
        int pos = c-'0';
        String mapString = letterMap[pos];
        // 遍历字符串，比如第一次得到的是2，就遍历"abc"
        for (int i = 0; i < mapString.length(); i++) {
            // 调用下一层递归，请看一下动态图
            letter.append(mapString.charAt(i));
            // 如果是String类型做拼接，效率会更高
            iterStr(str,letter,index+1);
            letter.deleteCharAt(letter.length()-1);
        }

    }
}
