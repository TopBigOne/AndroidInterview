package single_invoke_stack.leet_code_42;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/2/21 6:14 PM
 * @Desc : 接雨水（https://leetcode-cn.com/problems/trapping-rain-water/）
 * 字节 34 次
 * <p>
 * 题解：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 */
public class Trap {
    public int trap1(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                // 两堵墙之间的距离
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

    public int trap2(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int length = height.length;
        while (current < length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                // 两者之间的距离
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }

            stack.push(current);
            current++;
        }
        return sum;
    }

    public int trap3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int length = height.length;
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

    public int trap4(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int length = height.length;
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }

            stack.push(current);
            current++;
        }

        return sum;
    }

    public int trap5(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int length = height.length;
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }

            stack.push(current);
            current++;
        }

        return sum;
    }


    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int length = height.length;
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[current], height[stack.peek()]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

    public int trap7(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int length = height.length;
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[current], height[stack.peek()]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }

        return sum;
    }


    public int trap8(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int length = height.length;
        int current = 0;
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) break;
                ;
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[current], height[stack.peek()]);
                sum = sum + distance * (min - h);

            }

            stack.push(current);
            current++;
        }

        return sum;
    }

    public int trap9(int[] height) {
        int sum = 0;
        int length = height.length;
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }


    public int trap10(int[] height) {
        int sum = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        int length = height.length;
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()
                        ], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;

    }


    /**
     * 栈的解法
     *
     * @param height
     * @return
     */
    public int trap11(int[] height) {
        int sum = 0;
        int current = 0;
        int length = height.length;
        Stack<Integer> stack = new Stack<>();
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[current], height[stack.peek()]);
                sum = sum + distance * (min - h);

            }
            stack.push(current);
            current++;
        }
        return sum;

    }

    public int trap12(int[] height) {
        int sum = 0;
        int current = 0;
        int length = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        while (current < length) {
            // 如果栈不为空，并且当前指向的高度大于栈顶高度，就一直循环
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                // 取出要出栈的元素
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                // 两堵强之间的距离
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            // 当前指向的墙入栈
            stack.push(current);
            // 指针后移动
            current++;
        }
        return sum;
    }

    public int trap13(int[] height) {
        int sum = 0;
        int current = 0;
        int length = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        while (current < length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);

            }
            // 当前的墙体入栈
            stack.push(current);
            current++;
        }
        return sum;
    }

    public int trap14(int[] height) {
        int sum = 0;
        int currnet = 0;
        int len = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        while (currnet < len) {
            while (!stack.isEmpty() && height[currnet] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = currnet - stack.peek() - 1;
                int minHeight = Math.min(height[stack.peek()], height[currnet]);
                sum = sum + distance * (minHeight - h);
            }
            stack.push(currnet);
            currnet++;
        }
        return sum;
    }

    public int trap15(int[] height) {
        int sum = 0;
        int current = 0;
        int len = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        while (current < len) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int minHeight = Math.min(height[current], height[stack.peek()]);
                sum = sum + distance * (minHeight - h);
            }

            stack.push(current);
            current++;
        }
        return sum;

    }


}
