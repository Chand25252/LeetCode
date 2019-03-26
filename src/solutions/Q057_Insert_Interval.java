package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给出一个无重叠的 ，按照区间起始端点排序的区间列表。
    在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
*/

/**
 * @author Chand
 * @date 2019-03-26 14:33:58
 */
public class Q057_Insert_Interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        if (newInterval == null) {
            return intervals;
        }
        int startPosition;
        for (startPosition = 0; startPosition < intervals.size(); startPosition++) {
            if (newInterval.start <= intervals.get(startPosition).end) {
                break;
            }
        }
        int endPosition;
        for (endPosition = 0; endPosition < intervals.size(); endPosition++) {
            if (newInterval.end <= intervals.get(endPosition).end) {
                break;
            }
        }
        int start;
        int end;
        for (int i = 0; i < startPosition; i++) {
            result.add(intervals.get(i));
        }
        if (startPosition == intervals.size() || newInterval.start < intervals.get(startPosition).start) {
            start = newInterval.start;
        } else {
            start = intervals.get(startPosition).start;
        }
        if (endPosition == intervals.size() || newInterval.end < intervals.get(endPosition).start) {
            end = newInterval.end;
        } else {
            end = intervals.get(endPosition).end;
            endPosition++;
        }
        result.add(new Interval(start, end));
        for (int i = endPosition; i < intervals.size(); i++) {
            result.add(intervals.get(i));
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
