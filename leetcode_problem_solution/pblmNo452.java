//452. Minimum Number of Arrows to Burst Balloons

import java.util.Arrays;

public class pblmNo452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        int lastEnd = points[0][1];
        int firstEnd = points[0][0];
        for(int i=1;i<points.length;i++){
           if((firstEnd<=points[i][0] && points[i][0]<=lastEnd )){
            lastEnd = Math.min(lastEnd,points[i][1]);
            firstEnd =Math.max(firstEnd, points[i][0]);
            continue;
           }
           else{
            count++;
            lastEnd = points[i][1];
            firstEnd = points[i][0];
           }
        }
        return count;
    }
}
