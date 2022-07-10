package array.interval.leet_code_252;

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
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] pre = intervals[i - 1];
            if (curr[0] < pre[1]) {
                return false;
            }
        }
        return true;


    }


}
