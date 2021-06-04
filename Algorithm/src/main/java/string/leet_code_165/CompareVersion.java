package string.leet_code_165;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/4 18:57
 * @Url :  165. 比较版本号  https://leetcode-cn.com/problems/compare-version-numbers/
 * @Level :  medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class CompareVersion {

    public static final String DOT = "\\.";

    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";

        CompareVersion compareVersion = new CompareVersion();
        compareVersion.compareVersion(version1, version2);


    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split(DOT);
        String[] arr2 = version2.split(DOT);

        int aLength = arr1.length;
        int bLength = arr2.length;

        int loop = Math.min(aLength, bLength);
        for (int i = 0; i < loop; i++) {
            String a = arr1[i];
            String b = arr2[i];

            if (i == 0) {
                if (Integer.parseInt(a) > Integer.parseInt(b)) {
                    return 1;
                } else if (Integer.parseInt(a) < Integer.parseInt(b)) {
                    return -1;
                }
                return 0;
            }

            int t = 0;


        }

        return 0;

    }

}
