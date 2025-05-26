package string.interview_01_06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/11/10 21:12
 * @Url : https://leetcode.cn/problems/compress-string-lcci/
 * @Level :  easy
 * @Desc : 字符串压缩
 * @Counter :
 * @Answer :https://leetcode.cn/problems/compress-string-lcci/solutions/151961/shuang-zhi-zhen-fa-qu-lian-xu-zi-fu-cpython-by-net/?orderBy=most_votes
 */
public class CompressString {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        CompressString compressString = new CompressString();
        String result = compressString.compressString(s);
        System.err.println("result : "+result);
    }

    public String compressString(String S) {
        List<String> list = new ArrayList<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            String currStr = String.valueOf(c);
            if(list.size()==0){
                list.add(currStr);
                count+=1;
                continue;
            }
            if(list.get(list.size() - 1).equals(currStr)){
                count+=1;
            }else {
                list.add(String.valueOf(count));
                list.add(currStr);
                count=1;
            }
        }

        list.add(String.valueOf(count));
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        if (sb.length()>=S.length()) {
            return S;
        }

        return sb.toString();

    }
}
