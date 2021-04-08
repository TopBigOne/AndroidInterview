package stack.byte_17_21;


/**
 * @author : dev
 * @version :
 * @Date :  2021/3/25 11:37
 * @Desc : 字节：直方图的水量（https://leetcode-cn.com/problems/volume-of-histogram-lcci/）
 */
public class Trap {
    public int trap1(int[] height) {
        int l = 0;
        int len = height.length;
        int sum = 0;
        while (l < len) {
            int temp = 0;
            int r = len - 1;
            int lHeight = height[l];
            boolean isLight = height[r] > lHeight;
            int rHeight = height[r--];
            int next = len;
            while (l < r) {
                if (height[r] > lHeight || height[r] >= rHeight) {
                    temp = 0;
                    next = r;
                    isLight = height[r] > lHeight;
                    rHeight = height[r];
                } else {
                    temp = temp + (isLight ? lHeight - height[r] : rHeight - height[r]);
                }

                r--;
            }
            sum += temp;
            l = next;
        }
        return sum;

    }


    public int trap2(int[] height) {
        int l = 0;
        int len = height.length;
        int sum = 0;

        while (l < len) {
            int temp = 0;
            int r = len - 1;
            int singleHeight = height[l];
            boolean isLight = height[r] > singleHeight;
            int rHeight = height[r--];
            int next = len;
            //从0--->length -1
            while (l < r) {
                if (height[r] > singleHeight || height[r] >= rHeight) {
                    temp = 0;
                    next = r;
                    isLight = height[r] > singleHeight;
                    rHeight = height[r];
                } else {
                    temp = temp + (isLight ? singleHeight - height[r] : rHeight - height[r]);
                }
                r--;
            }
            sum += temp;
            l = next;
        }
        return sum;

    }

    public int trap3(int[] height) {
        int left = 0;
        int len = height.length;
        int sum = 0;
        while (left < len) {
            int temp = 0;
            int right = len - 1;
            int singleHeight = height[left];
            boolean isLight = height[right] > singleHeight;
            int rHeight = height[right--];
            int next = len;
            while (left < right) {
                if (height[right] > singleHeight || height[right] >= rHeight) {
                    temp = 0;
                    next = right;
                    isLight = height[right] > singleHeight;
                    rHeight = height[right];
                } else {
                    temp = temp + (isLight ? singleHeight - height[right] : rHeight - height[right]);
                }
                right--;
            }
            sum += temp;
            left = next;
        }

        return sum;


    }

    public int trap4(int[] height) {
        int left = 0;
        int length = height.length;
        int sum = 0;
        while (left < length) {
            int temp = 0;
            int right = length - 1;
            int singleHeight = height[left];
            boolean isLight = height[right] > singleHeight;
            int rHeight = height[right--];
            int next = length;
            while ((left < right)) {
                if (height[right] > singleHeight || height[right] >= rHeight) {
                    temp = 0;
                    next = right;
                    isLight = height[right] > singleHeight;
                    rHeight = height[right];
                } else {
                    temp = temp + (isLight ? singleHeight - height[right] : rHeight - height[right]);
                }
                right--;
            }
            sum += temp;
            left = next;
        }
        return sum;
    }


    public int trap5(int[] height) {
        int leftIndex = 0;
        int length = height.length;
        int sum = 0;
        while (leftIndex < length) {
            int temp = 0;
            int rightIndex = length - 1;
            int leftHeight = height[leftIndex];
            boolean isLight = height[rightIndex] > leftHeight;
            int rightHeight = height[rightIndex--];
            int next = length;
            while (leftIndex < rightIndex) {

                if (height[rightIndex] > leftHeight || height[rightIndex] >= rightHeight) {
                    temp = 0;
                    next = rightIndex;
                    isLight = height[rightIndex] > leftHeight;
                    rightHeight = height[rightIndex];
                } else {
                    temp = temp + (isLight ? leftHeight - height[rightIndex] : rightHeight - height[rightIndex]);
                }

                rightIndex--;
            }
            sum += temp;
            leftIndex = next;
        }

        return sum;


    }

    public int trap6(int[] height) {
        int length = height.length;
        int leftIndex = 0;
        int sum = 0;
        while (leftIndex < length) {
            int temp = 0;
            int rightIndex = length - 1;
            int leftHeight = height[leftIndex];
            int rightHeight = height[rightIndex--];
            boolean isLight = rightHeight > leftHeight;
            int next = length;
            while (leftIndex < rightIndex) {
                int innerRightHeight = height[rightIndex];
                if (innerRightHeight > leftHeight || innerRightHeight > rightHeight) {
                    temp = 0;
                    next = rightIndex;
                    isLight = innerRightHeight > leftHeight;
                    rightHeight = innerRightHeight;
                } else {
                    temp = temp + (isLight ? leftHeight - innerRightHeight : rightHeight - innerRightHeight);
                }

                rightIndex--;
            }
            sum += temp;
            leftIndex = next;
        }

        return sum;

    }


    public int trap7(int[] height) {
        int length = height.length;
        int leftIndex = 0;
        int sum = 0;
        while (leftIndex < length) {
            int temp = 0;
            int leftHeight = height[leftIndex];
            int rightIndex = length - 1;
            int rightHeight = height[rightIndex--];
            int next = length;
            boolean isLight = rightHeight > leftHeight;
            while (leftIndex < rightIndex) {
                int innerRightHeight = height[rightIndex];
                if (innerRightHeight > leftHeight || innerRightHeight > rightHeight) {
                    temp = 0;
                    next = rightIndex;
                    isLight = innerRightHeight > leftHeight;
                    rightHeight = innerRightHeight;
                } else {
                    temp = temp + (isLight ? leftHeight - innerRightHeight : rightHeight - innerRightHeight);
                }

                rightIndex--;
            }
            sum += temp;
            leftIndex = next;

        }
        return sum;
    }


    public int trap8(int[] height) {
        int length = height.length;
        int leftIndex = 0;
        int sum = 0;

        while (leftIndex < length) {
            int temp = 0;
            int rightIndex = length - 1;
            int leftHeight = height[leftIndex];
            boolean isLight = height[rightIndex] > leftHeight;
            int rightHeight = height[rightIndex--];
            int next = length;
            while (leftIndex < rightIndex) {
                int innerRightHeight = height[rightIndex];
                if (innerRightHeight > leftHeight || innerRightHeight >= rightHeight) {
                    temp = 0;
                    next = rightIndex;
                    isLight = innerRightHeight > leftHeight;
                    rightHeight = innerRightHeight;
                } else {
                    temp = temp + (isLight ? leftHeight - innerRightHeight : rightHeight - innerRightHeight);
                }
                rightIndex--;

            }
            sum += temp;
            leftIndex = next;
        }
        return sum;
    }

    public int trap9(int[] height) {
        int length = height.length;
        int leftIndex = 0;
        int sum = 0;
        while (leftIndex < length) {
            int temp = 0;
            int leftHeight = height[leftIndex];
            int rightIndex = length - 1;
            int rightHeight = height[rightIndex--];
            boolean isLight = rightHeight > leftHeight;
            int next = length;
            while (leftIndex < rightIndex) {
                int innerRightHeight = height[rightIndex];
                if (innerRightHeight > leftHeight || innerRightHeight > rightHeight) {
                    temp = 0;
                    next = rightIndex;
                    isLight = innerRightHeight > leftHeight;
                    rightHeight = innerRightHeight;


                } else {
                    temp = temp + (isLight ? leftHeight - innerRightHeight : rightHeight - innerRightHeight);

                }

                rightIndex--;
            }
            sum += temp;
            // 左指针，也开始右移动
            leftIndex = next;

        }
        return sum;
    }


    public int trap10(int[] height) {
        int length = height.length;
        int sum = 0;
        int leftIndex = 0;
        while (leftIndex < length) {
            int temp = 0;
            int rightIndex = length - 1;
            int leftHeight = height[leftIndex];
            int rightHeight = height[rightIndex--];

            boolean isLight = rightHeight > leftHeight;
            int next = length;
            while (leftIndex < rightIndex) {
                int innerRightHeight = height[rightIndex];

                if (innerRightHeight > leftHeight || innerRightHeight > rightHeight) {
                    temp = 0;
                    next = rightIndex;
                    isLight = innerRightHeight > leftHeight;
                    rightHeight = innerRightHeight;
                } else {
                    temp = temp + (isLight ? leftHeight - innerRightHeight : rightHeight - innerRightHeight);
                }
                rightIndex--;
            }

            sum += temp;
            leftIndex = next;
        }
        return sum;



    }

}
