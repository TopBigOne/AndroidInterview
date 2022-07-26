package math.leet_code_69;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/23 06:39
 * @Desc :
 * https://leetcode.cn/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
 * <p>
 * 1: 分段
 * 2： 试根
 * 3： 求余项
 */
public class MySqrt2 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x >>> 1;
        // 在[left,right] 查找目标元素
        while (left < right) {
            // +1 把取中间数的方式改成上取整。
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                // [left,mid-1]
                right = mid - 1;
            } else {
                // [mid,right]
                left = mid;
            }
        }
        return left;
    }

    public int mySqrt2(int x) {
        int left = 1;
        int right = x >>> 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x >>> 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int mySqrt4(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x >>> 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int mySqrt5(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x >>> 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int mySqrt6(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x >>> 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;

    }


    public int mySqrt7(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x >>> 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;


    }

}
