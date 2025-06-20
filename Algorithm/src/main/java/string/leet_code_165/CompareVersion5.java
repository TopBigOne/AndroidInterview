package string.leet_code_165;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 17:01
 * @Desc :
 */
public class CompareVersion5 {
    public static void main(String[] args) {
        String v1 = "1.01";
        String v2 = "1.001";
        CompareVersion5 compareVersion = new CompareVersion5();
        int result = compareVersion.compareVersion(v1, v2);
        System.err.println("result :" + result);

    }

    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        int n = version1.length();
        int m = version2.length();
        while (i < n || j < m) {
            int num1 = 0;
            int num2 = 0;
            while (i < n && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i++) - '0';
            }

            while (j < m && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j++) - '0';
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;

    }
}
