package dp.leet_code_474;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2/3/21 12:31 AM
 * @Desc :474. 一和零
 * https://leetcode-cn.com/problems/ones-and-zeroes/solution/dong-tai-gui-hua-zhuan-huan-wei-0-1-bei-bao-wen-ti/
 */
public class Solution {
    private int[] calcZeroAndOne(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }

    private int[] calcZeroAndOne2(String s) {
        int[] res = new int[2];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            res[c - '0']++;
        }
        System.out.println("calcZeroAndOne2 res : " + Arrays.toString(res));
        return res;
    }

    private int[] calcZeroAndOne3(String s) {
        int[] res = new int[2];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            res[c - '0']++;
        }
        return res;
    }

    public int[] calZeroAndOne4(String s) {
        int[] res = new int[2];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            res[c - '0']++;
        }

        return res;

    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String s : strs) {
            int[] zeroAndOne = calcZeroAndOne(s);
            int zeros = zeroAndOne[0];
            int ones = zeroAndOne[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String s : strs) {
            int[] zeroAndOne = calcZeroAndOne2(s);
            int zeros = zeroAndOne[0];
            int ones = zeroAndOne[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm3(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String s : strs) {
            int[] zerosAndOnes = calZeroAndOne4(s);
            int zeros = zerosAndOnes[0];
            int ones = zerosAndOnes[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm4(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (String str : strs) {
            int[] zerosAndOnes = calZeroAndOne4(str);
            int zeros = zerosAndOnes[0];
            int ones = zerosAndOnes[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);

                }

            }

        }

        return dp[m][n];
    }


    public int  findMaxForm5(String [] strings,int m ,int n){
        int [][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (String string : strings) {
            int[] zerosAndOnes = calZeroAndOne5(string);
            int zeros = zerosAndOnes[0];
            int ones = zerosAndOnes[1];
            for (int i = m; i>=zeros ; i--) {
                for (int j = n; j >=ones; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                }

            }
        }

        return dp[m][n];
    }

    private int[] calZeroAndOne5(String string) {
      int [] res =  new int[2];
      char[] chars = string.toCharArray();
        for (char c : chars) {
            res[c-'0']++;
        }
        return  res;
    }






    public int findMaxForm6(String [] strs ,int m ,int n){
        int [][]  dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (String str : strs) {
            int [] zerosAndOnes = calcuAerosAndOnes6(str);
            int zeros = zerosAndOnes[0];
            int ones = zerosAndOnes[1];
            for(int i = m ;i>=zeros;i--){
                for(int j = n;j>=ones;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] calcuAerosAndOnes6(String str) {
        int []result = new int[2];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            result[c-'0']++;
        }
        return  result;
    }



    public int findMaxForm7(String [] strs,int m ,int n){
        int [][] dp  = new int[m+1][n+1];
        dp[0][0] = 1;
        for (String str : strs) {
            int [] zerosAndOnes = calcZeorsAndOnes7(str);
            int zeros = zerosAndOnes[0];
            int ones = zerosAndOnes[1];
            for(int i = m;i>=zeros;i--){
                for(int j= n;j>=ones;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones]+1);

                }
            }
        }
        return dp[m][n];
    }

    private int[] calcZeorsAndOnes7(String str) {
        int [] res = new int[2];
        char [] chars = str.toCharArray();
        for (char c : chars) {
            res[c-'0']++;
        }
        return  res;
    }



}
