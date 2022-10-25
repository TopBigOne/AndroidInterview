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
public class BackspaceCompare {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        boolean result = backspaceCompare.backspaceCompare(s, t);
        System.err.println("result : " + result);

    }

    /**
     * @param s s = "ab#c", t = "ad#c"
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        return convert3(s).equals(convert3(s));

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

    private String convert2(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int size = 0;

        for (int i = cs.length - 1; i >= 0; i--) {
            char currChar = s.charAt(i);
            if (currChar == '#') {
                size++;
                continue;
            }
            if (size == 0) {
                sb.append(currChar);
                continue;
            }
            size--;

        }
        return sb.toString();


    }

    private String convert3(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int size = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '#') {
                size++;
            } else if (size == 0) {
                sb.append(cs[i]);
            } else {
                size--;
            }
        }
        return sb.toString();

    }


}
