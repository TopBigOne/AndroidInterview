package interval.leet_code_252;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/10 04:03
 * @Desc :
 */
public class CanAttendMeeting {
    public static void main(String[] args) {
        int[][] intervals = {{7, 10}, {2, 4}};
        CanAttendMeeting canAttendMeeting = new CanAttendMeeting();
        boolean result = canAttendMeeting.canAttendMeetings(intervals);
        System.err.println("result : " + result);
    }

    public boolean canAttendMeetings(int[][] intervals) {
        // 按照会议的开始时间，从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 上一个会议时间
            int[] pre = intervals[i - 1];
            // 当前会议的时间
            int[] curr = intervals[i];
            // 当前会议的开始时间，小于上一个会议的结束时间，就表明有重合
            if (curr[0] < pre[1]) {
                return false;
            }
        }
        return true;
    }


}
