package stack.leet_code_253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  3/18/21 12:09 AM
 * @Desc : 字节-253-（https://leetcode-cn.com/problems/meeting-rooms-ii/）
 * <p>
 * 题目就是：要统计同一时刻进行的最大会议的数量
 * 我们可以把所有的开始时间和结束时间放在一起排序，
 * 用cur表示当前进行的会议数量，遍历排序后的时间数组
 * 如果是开始时间，cur加1，如果是结束时间，cur减1
 * 在遍历的过程中，cur出现的最大值就是需要的房间数。
 */
public class MinMeetingRoom {
    public static void main(String[] args) {
        MinMeetingRoom minMeetingRoom = new MinMeetingRoom();
        int[][] raw = {{1, 4}, {2, 8}, {5, 7}, {5, 9}, {3, 6}};
        minMeetingRoom.minMeetingRooms(raw);
        // minMeetingRoom.tt();
    }

    public void tt() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        minHeap.add(5);
        minHeap.add(1);
        minHeap.add(8);
        minHeap.add(33);
        System.out.println("minHeap  " + minHeap);

    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 对 二维数组进行 start 排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 结果：[
        //      [1, 4],
        //      [2, 8],
        //      [3, 6],
        //      [5, 7],
        //      [5, 9] ]
        System.out.println(Arrays.deepToString(intervals));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        //  存放结束时间
        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int curStartTime = intervals[i][0];
            System.out.println("curStartTime : " + curStartTime);
            int curPeekTime = minHeap.peek();
            System.out.println("curPeekTime       : " + curPeekTime);
            if (curStartTime >= curPeekTime) {
                minHeap.poll();
            }
            int curEndTime = intervals[i][1];
            System.out.println("curEndTime      : " + curEndTime);
            minHeap.add(curEndTime);
            // System.out.println("每一次的 minHeap : "+minHeap);
        }

        return minHeap.size();
    }

    public int minMeetRooms(int[][] interval) {
        Arrays.sort(interval, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        // 存放二维数组中，第一个数组中的第二个值
        minHeap.add(interval[0][1]);
        // 从1开始遍历
        for (int i = 1; i < interval.length; i++) {
            int startTime = interval[i][0];
            int peekTime = minHeap.peek();
            if (startTime >= peekTime) {
                minHeap.poll();
            }
            int endTime = interval[i][1];
            minHeap.add(endTime);

        }

        return minHeap.size();
    }

    public int minMeetRooms3(int[][] interval) {
        Arrays.sort(interval, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.add(interval[0][1]);
        for (int i = 1; i < interval.length; i++) {
            int startTime = interval[i][0];
            int peekEndTime = minHeap.peek();

            if (startTime >= peekEndTime) {
                minHeap.poll();
            }
            int endTime = interval[i][1];
            minHeap.add(endTime);

        }
        return minHeap.size();
    }

    public int minMeetRooms4(int[][] interval) {
        Arrays.sort(interval, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.add(interval[0][1]);

        for (int i = 1; i < interval.length; i++) {
            int startTime = interval[i][0];
            int peekEndTime = minHeap.peek();
            if (startTime >= peekEndTime) {
                minHeap.poll();
            }
            int endTime = interval[i][1];
            minHeap.add(endTime);
        }
        return minHeap.size();
    }

    /**
     * 最少会议室
     *
     * @param interval
     * @return
     */
    public int minMeetRooms5(int[][] interval) {
        Arrays.sort(interval, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // add the first meeting end time;
        minHeap.add(interval[0][1]);
        for (int i = 1; i < interval.length; i++) {
            if (interval[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(interval[i][1]);
        }
        return minHeap.size();
    }

    public int minMeetRooms6(int[][] interval) {
        Arrays.sort(interval, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.add(interval[0][1]);
        for (int i = 1; i < interval.length; i++) {
            if (interval[i][0] > minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(interval[i][1]);

        }

        return minHeap.size();


    }


}
