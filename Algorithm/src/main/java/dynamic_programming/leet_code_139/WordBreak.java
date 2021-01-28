package dynamic_programming.leet_code_139;


import java.io.EOFException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import sun.security.provider.Sun;


/**
 * @author : dev
 * @version :
 * @Date :  1/28/21 12:57 AM
 * @Desc :
 */
public class WordBreak {
    public HashMap<String, Boolean> hash = new HashMap<>(16);

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        // 方便 check 构建一个 hash table
        for (String word : wordDict) {
            hash.put(word, true);
        }
        // 初始化
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && check(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[length];

    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        for (String word : wordDict) {
            hash.put(word, true);
        }
        dp[0] = true;
        for (int i = 1; i <= length; i++) {

            System.out.println("第" + i + "轮遍历：");
            // 倒序
            for (int j = i - 1; j >= 0; j--) {
                String subStr = s.substring(j, i);
                boolean checkResult = check(subStr);
                System.out.println("dp[" + j + "] :" + dp[j] + ", subStr :" + subStr + ", checkResult: " + checkResult);
                dp[i] = dp[j] && checkResult;
                if (dp[i]) {
                    break;
                }
            }
            System.out.println("result of dp[]: " + Arrays.toString(dp));
            System.out.println("----------------\n");

        }
        return dp[length];
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (String word : wordDict) {
            hash.put(word, true);
        }

        for (int i = 1; i <= length; i++) {
            // 倒序，截取字符串
            for (int j = i - 1; j >= 0; j--) {
                String subString = s.substring(j, i);
                boolean checkResult = check(subString);
                dp[i] = dp[j] && checkResult;
                if (dp[i]) {
                    break;
                }

            }

        }

        return dp[length];
    }

    public boolean wordBreak4(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (String word : wordDict) {
            hash.put(word, true);
        }
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && check(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[length];
    }

    public boolean wordBreak5(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        for (String word : wordDict) {
            hash.put(word, true);
        }


        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && check(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[length];
    }

    public boolean wordBreak6(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (String word : wordDict) {
            hash.put(word, true);
        }
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && check(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[length];
    }

    private boolean check(String substring) {
        return hash.getOrDefault(substring, false);
    }


    public boolean wordBreak7(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (String word : wordDict) {
            hash.put(word, true);
        }
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String subStr = s.substring(j, i);
                boolean checktResult = check(subStr);
                dp[i] = dp[j] && checktResult;
                if (dp[i]) {
                    break;
                }
            }

        }
        return dp[length];
    }

    public boolean wordBreak8(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (String word : wordDict) {
            hash.put(word, true);
        }
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String subStr = s.substring(j, i);
                boolean checkResult = check(subStr);
                dp[i] = dp[j] && checkResult;
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[length];
    }

    public boolean wordBreak9(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (String word : wordDict) {
            hash.put(word, true);
        }
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && check(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[length];
    }

}
