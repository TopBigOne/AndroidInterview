package string.offer_67;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/13 17:59
 * @Desc :
 */
public class StrToInt {
    public static void main(String[] args) {
        String s = "  -0012a42";
        StrToInt strToInt = new StrToInt();
        int result = strToInt.strToInt(s);
        System.err.println("result : " + result);
    }


    public int strToInt(String str) {
        // 1: 去除空格
        str = str.trim();
        int len = str.length();
        if (len == 0) {
            return 0;
        }

        if (str.startsWith("w") || str.startsWith(".")) {
            return 0;
        }
        // "+-12"
        if (str.startsWith("+-")) {
            System.out.println("+-  : -----> 0");
            return 0;
        }

        // "-+1";
        if (str.startsWith("-+")) {
            System.out.println("-+  : -----> 0");
            return 0;
        }
        boolean isFu = false;

        StringBuilder stringBuilder = new StringBuilder(str);
        if (isFu){
            stringBuilder.deleteCharAt(0);
        }

        int left = 0;
        int right = stringBuilder.length();

        // 2： 删除不是 0-9的字符
        while (left < right) {
            char itemChar = stringBuilder.charAt(left);
            // 处理小数点
            if (itemChar == '.') {
                stringBuilder.delete(left, right);
                String temp = stringBuilder.toString();
                if (Integer.MAX_VALUE < Long.parseLong(temp)) {
                    return Integer.MAX_VALUE - 1;
                }
                if (Integer.MIN_VALUE > Long.parseLong(temp)) {
                    return Integer.MIN_VALUE;
                }
                return Integer.parseInt(temp);
            }


            if (itemChar != '-' && (itemChar < '0' || itemChar > '9')) {
                stringBuilder.deleteCharAt(left);
                left = 0;
                right = stringBuilder.length();
                continue;
            }
            left++;
        }
        System.out.println("删除不是 0-9 的字符：" + stringBuilder);

        // 删除开头是0的字符：000009；  010
        left = 0;
        right = stringBuilder.length();

        if (stringBuilder.toString().startsWith("0")) {
            while (left < right) {
                char itemChar = stringBuilder.charAt(left);
                if (itemChar == '0') {
                    stringBuilder.deleteCharAt(left);
                    left = 0;
                    right = stringBuilder.length();
                    continue;
                }
                break;
            }

        }


        System.out.println("删除 0 开头的部分 ：" + stringBuilder);

        String temp = stringBuilder.toString();
        if (temp.length() == 0) {
            return 0;
        }

        if (temp.length() == 1 && temp.charAt(0) < '0' || temp.charAt(0) > '9') {
            return 0;
        }

        if (Long.parseLong(temp) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (Long.parseLong(temp) < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return Integer.parseInt(temp);


    }


}
