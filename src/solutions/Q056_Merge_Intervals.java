package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给出一个区间的集合，请合并所有重叠的区间。
*/

/**
 * @author Chand
 * @date 2019-03-26 11:29:02
 */
public class Q056_Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return result;
        }
        int size = 0;
        for (int i = 0; i < intervals.size(); i++) {
            size = intervals.get(i).end > size ? intervals.get(i).end : size;
        }
        int[] arr = new int[size + 1];
        int[] count = new int[size + 1];
        for (int i = 0; i < intervals.size(); i++) {
            arr[intervals.get(i).start]--;
            arr[intervals.get(i).end]++;
            count[intervals.get(i).start]++;
            count[intervals.get(i).end]++;
        }
        int cal = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                start = cal == 0 ? i : start;
                cal += arr[i];
                continue;
            }
            if (arr[i] > 0) {
                end = i;
                cal += arr[i];
                if (cal == 0) {
                    Interval temp = new Interval(start, end);
                    result.add(temp);
                }
                continue;
            }
            if (count[i] != 0 && cal == 0) {
                Interval temp = new Interval(i, i);
                result.add(temp);
            }
        }
        return result;
    }

    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
