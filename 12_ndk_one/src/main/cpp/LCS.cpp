//
// Created by Dev on 1/12/22.
//

#include <string>
#include <unordered_map>
#include <math.h>

using namespace std;

/**
 * leet code 300 ：最长无重复子串；
 */
class LCS {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;
        int left = 0;
        int right = 0;
        int res = 0;
        int size = s.size();
        while (right < size) {
            char c = s[right];
            window[c]++;
            while (window[c] > 1) {
                char d = s[left];
                left++;
                window[d]--;
            }
            res = max(res, right - left);
            right++;
        }
        return res;
    };
};

