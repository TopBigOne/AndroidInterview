package string.leet_code_6;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/25 20:55
 * @Desc : Z 字形 变换 medium  字节11 ：https://leetcode-cn.com/problems/zigzag-conversion/
 * <p>
 * 注意，这个题在国外，被骂的很惨
 * <p>
 * 一姐：https://www.youtube.com/watch?v=CPamjPdCvIk
 */
public class NZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) return s;
        StringBuilder[] array = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }

        int index = 0;
        int dir = 1;
        for (char c : s.toCharArray()) {
            array[index].append(c);
            index += dir;
            if (index == 0 || index == numRows - 1) {
                dir = -dir;
            }

        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : array) {
            result.append(stringBuilder);
        }

        return result.toString();

    }

    public String convert2(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int idx = 0;
        while (idx < len) {
            // 处理直上直下的
            for (int i = 0; i < numRows && idx < len; i++) {
                char currChar1 = c[idx++];
                sb[i].append(currChar1);
            }
            // 处理斜的
            for (int i = numRows - 2; i >= 1 && idx < len; i--) {
                char currChar2 = c[idx++];
                sb[i].append(currChar2);
            }
        }

        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();


    }


}
