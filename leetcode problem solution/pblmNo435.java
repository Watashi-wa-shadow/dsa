//435. Non-overlapping Intervals

import java.util.Arrays;

public class pblmNo435 {
     public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int lastEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
           int currentStart = intervals[i][0];
           if(currentStart>= lastEnd)
                lastEnd = intervals[i][1];
            else
                count++;
        }
        return count;
    }
}
