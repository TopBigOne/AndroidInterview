package string.leet_code_844;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/19 21:39
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class BackspaceCompare2 {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        BackspaceCompare2 backspaceCompare = new BackspaceCompare2();
        boolean result = backspaceCompare.backspaceCompare(s, t);
        System.err.println("result : " + result);

    }

    /**
     * @param s s = "ab#c", t = "ad#c"
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        return convert(s).equals(convert(t));

    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int size = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '#') {
                size++;
                continue;
            }
            if (size == 0) {
                sb.append(cs[i]);
                continue;
            }
            size--;
        }
        return sb.toString();
    }



}
