package stack.leet_code_395;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  3/10/21 8:27 PM
 * @Desc :至少有K个重复字符的最长子串（https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/）
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for (int p = 0; p < 26; p++) {
            Arrays.fill(cnt, 0);
            for (int i = 0, j = 0, tot = 0, sum = 0; i < n; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                // 如果添加到cnt 之后，为1，说明字符总数+1；
                if (cnt[u] == 1) {
                    tot++;
                }
                if (cnt[u] == k) {
                    sum++;
                }
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    // 如果添加到cnt之后为0 ，说明字符总数-1；
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }
                if (tot == sum) {
                    ans = Math.max(ans, i - j + 1);
                }

            }
        }
        return ans;
    }

    public int longestSubstring2(String s, int k) {
        int ans = 0;
        int len = s.length();
        char[] cs = s.toCharArray();
        int limit = 26;
        int[] cnt = new int[limit];
        for (int p = 0; p < limit; p++) {
            Arrays.fill(cnt, 0);
            for (int i = 0, j = 0, tot = 0, sum = 0; i < len; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                if (cnt[u] == 1) {
                    tot++;
                }
                if (cnt[u] == k) {
                    sum++;
                }

                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    // 如果添加到cnt 之后为0，说明字符总数-1；
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }
                if (tot == sum) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }
        return ans;

    }


    public int longestSubstring3(String s, int k) {
        int ans = 0;
        int len = s.length();
        char[] cs = s.toCharArray();

        int[] cnt = new int[26];
        for (int p = 0; p < 26; p++) {
            Arrays.fill(cnt, 0);

            for (int i = 0, j = 0, tot = 0, sum = 0; i < len; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;

                if (cnt[u] == 1) {
                    tot++;
                }
                if (cnt[u] == k) {
                    sum++;
                }

                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }
                if (tot == sum) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }
        return ans;
    }


    public int longestSubstring4(String s, int k) {
        int ans = 0;
        int len = s.length();
        int limit = 26;
        char[] cs = s.toCharArray();
        int[] cnt = new int[limit];

        for (int p = 0; p < limit; p++) {
            Arrays.fill(cnt, 0);

            for (int i = 0, j = 0, tot = 0, sum = 0; i < len; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                if (cnt[u] == 1) {
                    tot++;
                }

                if (cnt[u] == k) {
                    sum++;
                }

                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }

                if (tot == sum) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }

        return ans;

    }


    public int longestSubString5(String s, int k) {
        int len = s.length();
        int limit = 26;
        char[] cs = s.toCharArray();
        int[] cnt = new int[limit];
        int result = 0;
        for (int p = 0; p < limit; p++) {
            Arrays.fill(cnt, 0);
            for (int i = 0, j = 0, tot = 0, sum = 0; i < len; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                if (cnt[u] == 1) {
                    tot++;
                }
                if (cnt[u] == k) {
                    sum++;
                }
                while (p > tot) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }

                if (tot == sum) {
                    result = Math.max(result, i - j + 1);
                }
            }
        }
        return result;


    }


    public int longestSubString6(String s, int k) {
        int result = 0;
        int limit = 26;
        int len = s.length();
        int[] cnt = new int[limit];
        char[] cs = s.toCharArray();
        for (int p = 0; p < limit; p++) {
            Arrays.fill(cnt, 0);
            for (int i = 0, j = 0, tot = 0, sum = 0; i < len; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                if (cnt[u] == 1) {
                    tot++;
                }

                if (cnt[u] == k) {
                    sum++;
                }

                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    if (cnt[t] == 0) {
                        tot--;

                    }

                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }

                if (tot == sum) {
                    result = Math.max(result, i - j + 1);
                }

            }
        }

        return result;
    }

    public int longestSubString7(String s, int k) {
        int limit = 26;
        int len = s.length();
        int result = 0;
        char[] cs = s.toCharArray();
        int[] cnt = new int[limit];
        for (int p = 0; p < limit; p++) {
            Arrays.fill(cnt, 0);
            for (int i = 0, j = 0, tot = 0, sum = 0; i < len; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                if (cnt[u] == 1) {
                    tot++;
                }
                if (cnt[u] == k) {
                    sum++;
                }
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }
                if (tot == sum) {
                    result = Math.max(result, i - j + 1);
                }
            }

        }

        return result;

    }

    public int longestSubstring8(String s, int k) {
        int limit = 26;
        int result = 0;
        int len = s.length();
        char[] cs = s.toCharArray();
        int[] cnt = new int[limit];
        for (int p = 0; p < limit; p++) {
            Arrays.fill(cnt, 0);
            for (int i = 0, j = 0, tot = 0, sum = 0; i < len; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                if (cnt[u] == 1) {
                    tot++;
                }
                if (cnt[u] == k) {
                    sum++;
                }
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }
                if (tot == sum) {
                    result = Math.max(result, i - j + 1);
                }
            }
        }
        return result;


    }
}
