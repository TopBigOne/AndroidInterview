package string.offer_20;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/7 21:28
 * @Desc :
 *
 * 题解：https://www.bilibili.com/video/BV1G7411U7ti?spm_id_from=333.337.search-card.all.click
 */
public class IsNumber2 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        // 将'E' 替换成'e'
        s = s.replace('E', 'e');
        if (s.indexOf('e') >= 0) {
            int idxE = s.indexOf('e');
            String first = s.substring(0, idxE);
            String second = s.substring(idxE + 1);
            if (second.length() > 0) {
                if (second.charAt(0) == '+' || second.charAt(0) == '-') {
                    second = second.substring(1);
                }
            }

            return validNumber(first) && validNumber(second);
        }
        return validNumber(s);
    }

    private boolean validNumber(String s) {
        if (s.indexOf('.') >= 0) {
            int idxDot = s.indexOf('.');
            String first = s.substring(0, idxDot);
            String second = s.substring(idxDot + 1);
            if (first.length() > 0 && second.length() > 0) {
                return validPureNumber(first) && validPureNumber(second);
            }
            if (second.length() > 0) {
                return validPureNumber(second);
            }

            if (first.length() > 0) {
                return validPureNumber(first);
            }
        }
        return validPureNumber(s);
    }

    private boolean validPureNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}
