package string.byte_code;

/**
 * @author : dev
 * @version :
 * @Date :  7/11/21 11:34 PM
 * @Desc : 大数相加  : https://www.cnblogs.com/0201zcr/p/4906283.html
 */
public class BigNumberAdd {
    public static void main(String[] args) {
        BigNumberAdd bigNumberAdd = new BigNumberAdd();
        String result = bigNumberAdd.add("911", "222222");
        System.out.println("result : " + result);
    }

    public String add(String n1, String n2) {
        StringBuilder result = new StringBuilder();
        // 1：字符串啊反转
        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();

        int len1 = n1.length();
        int len2 = n2.length();

        int maxLen = Math.max(len1, len2);
        // 是否越界
        boolean nOverFlow = false;
        // 溢出数量
        int nTakeOver = 0;
        // 2. 把两个字符串补齐，短字符串的高位用 0 补齐；
        if (len1 < len2) {
            StringBuilder n1Builder = new StringBuilder(n1);
            for (int i = len1; i < len2; i++) {
                n1Builder.append("0");
            }
            n1 = n1Builder.toString();
        }

        if (len1 > len2) {
            StringBuilder n2Builder = new StringBuilder(n1);
            for (int i = len2; i < len1; i++) {
                n2Builder.append("0");

            }
            n1 = n2Builder.toString();
        }

        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "");

            if (nSum >= 10) {
                if (i == (maxLen - 1)) {
                    nOverFlow = true;
                }
                nTakeOver = 1;
                result.append(nSum - 10);
            } else {
                nTakeOver = 0;
                result.append(nSum);
            }
        }

        if (nOverFlow) {
            result.append(nTakeOver);
        }
        return result.reverse().toString();
    }


}
