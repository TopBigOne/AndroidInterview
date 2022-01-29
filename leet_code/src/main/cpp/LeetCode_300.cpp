//
// Created by Dev on 1/29/22.
//

#include "LeetCode_300.h"


#include <vector>
#include <cmath>

using namespace std;

int LeetCode_300::lcs(vector<int> &nums) {
    int size;
    if ((size = nums.size()) <= 1) {
        return size;
    }
    vector<int> dp(size, 1);
    int result = 0;
    for (int i = 1; i < size; i++) {
        for (int j = i - 1; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }
    return result;
}
