package math.new_ke;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/17 11:18
 * @Url :
 * @Level :  easy  medium hard
 * @Desc : M 的N进制，M是10进制树
 * @Counter :
 * @Answer :
 */
public class N_Base {

    public static void main(String[] args) {
        N_Base n_base = new N_Base();
        n_base.M2N(32, 2);
    }

    public String M2N(int m, int n) {
        StringBuilder sb = new StringBuilder();
        calculate(m, n, sb);
        String result = sb.reverse().toString();
        System.out.println("result : " + result);
        return result;
    }

    private void calculate(int m, int n, StringBuilder sb) {
        while (m != 0) {
            int temp = m % n;

            String res;
            if (temp == 10) {
                res = "A";
            } else if (temp == 11) {
                res = "B";
            } else if (temp == 12) {
                res = "C";
            } else if (temp == 13) {
                res = "D";
            } else if (temp == 14) {
                res = "E";
            } else if (temp == 15) {
                res = "F";
            } else {
                res = String.valueOf(temp);
            }

            sb.append(res);
            m /= n;
        }
    }
}
