package test;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * 解密犯罪时间
 */
public class DecodeTime {
    public String decodeTime(String time) {
        char[] chars = time.toCharArray();
        ArrayList<Integer> nums = new ArrayList<>();
        for (char c : chars) {
            if (c != ':') {
                nums.add(c - '0');
            }
        }
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            for (int j : nums) {
                if (i <= 5) {
                    list.add(i * 10 + j);
                }
            }
        }
        list.sort(Comparator.comparing(o -> o));
        for (int i : list) {
            if (i <= minute) {
                continue;
            }
            return formatCurrentTime(hour + ":" + i);
        }

        if (hour != 23) {
            for (int i : list) {
                if (i <= hour) {
                    continue;
                }
                if (i <= 23) {
                    //12:59 ->15:11
                    return formatCurrentTime(i + ":" + list.get(0));
                }
            }
        }
        return formatCurrentTime(list.get(0) + ":" + list.get(0));
    }

    public String formatCurrentTime(String time) {
        String[] tempSplit = time.split(":");
        String hour = tempSplit[0];
        String minute = tempSplit[1];
        hour = hour.length() == 2 ? hour : "0" + hour;
        minute = minute.length() == 2 ? minute : "0" + minute;
        return hour + ":" + minute;
    }
}
