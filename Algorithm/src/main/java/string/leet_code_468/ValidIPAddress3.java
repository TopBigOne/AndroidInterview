package string.leet_code_468;

import javax.print.DocFlavor;

import jdk.nashorn.internal.objects.NativeNumber;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/6 13:26
 * @Desc :
 */
public class ValidIPAddress3 {
    public static final String NEITHER = "Neither";

    public String validIPAddress(String queryIP) {

        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return isIpV4(queryIP);
        }
        if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return isIpv6(queryIP);
        }
        return NEITHER;
    }

    private String isIpV4(String queryIP) {
        String[] nums = queryIP.split("\\.", -1);
        for (String num : nums) {
            int len = num.length();
            if (len == 0 || len > 3) {
                return NEITHER;
            }
            if (len > 1 && num.startsWith("0")) {
                return NEITHER;
            }
            for (char c : num.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return NEITHER;
                }
            }
            if (Integer.parseInt(num) > 255) {
                return NEITHER;
            }
        }
        return "IPv4";
    }


    private String isIpv6(String queryIP) {
        String hexdigits = "0123456789abcdefABCDEF";
        String[] nums = queryIP.split(":", -1);
        for (String num : nums) {
            //长度：大于0 ，小于等于4；
            if (num.length() == 0 || num.length() > 4) {
                return NEITHER;
            }
            for (char ch : num.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return NEITHER;
                }
            }
        }
        return "IPv6";
    }
}
