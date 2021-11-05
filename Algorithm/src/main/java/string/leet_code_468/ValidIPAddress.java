package string.leet_code_468;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/31 21:43
 * @Url :  https://leetcode-cn.com/problems/validate-ip-address/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/validate-ip-address/solution/mian-shi-guan-xiang-kan-dao-shi-yao-qie-d23jw/
 */
public class ValidIPAddress {
    /**
     * 抽象固定维护寻找
     * 先抽象写出框架，bool is4(string),bool is6(string), 先split放到vector，千万不要面向测试用例编程，面试官想要看到什么？
     *
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        if(is4(IP))return "IPv4";
        else if(is6(IP))return "IPv6";
        return "Neither";


    }

    private boolean is6(String IP) {
        List<String> ip = new ArrayList<>();


        return false;
    }

    private boolean is4(String ip) {
        return false;
    }
}
