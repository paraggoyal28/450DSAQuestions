package question14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionJava {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        List<int[]> res = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by first parameter
        for (int i = 0; i < intervals.length; ++i) {
            if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                // overlap
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}
