package string.leet_code_468;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/31 21:43
 * @Url :   468 : 有效IP : https://leetcode-cn.com/problems/validate-ip-address/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/validate-ip-address/solution/mian-shi-guan-xiang-kan-dao-shi-yao-qie-d23jw/
 */
public class ValidIPAddress {

    public String validIPAddress(String queryIP) {
        // 检查ipv4 的分割符
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(queryIP);
        }
        if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(queryIP);
        }
        return "Neither";
    }

    /**
     * 2.1 检查IPV4的合法性：
     * （1）字符串数组应该等于4；
     * （2）字符串长度应该在1～3之间；
     * （3）字符串如果不是0，不能以0开头；
     * （4）不能含有数字以外的字符；
     * （5）对应的数字不能超过255.
     * 2.2 检查IPV6的合法性：
     * （1）数组长度应该等于8；
     * （2）字符串长度应该在1～4之间；
     * （3）不能含有非法字符。
     *
     * @param IP
     * @return
     */
    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        // “192.168.1.1”
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3) {
                return "Neither";
            }
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1) {
                return "Neither";
            }
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4) {
                return "Neither";
            }
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }


}
