//1948 Minimum Difference Between Highest and Lowest of K Scores
import java.util.*;
public class pblmNo1984{
    public int minimumDifference(int[] arr, int m) {
        int minimum=Integer.MAX_VALUE;
        Arrays.sort(arr);
        if(m <= 1){
            return 0;
        }
        //finding the value for which the difference after i+m index will be minimum.
        for(int i=0;i<=arr.length-m;i++){
            int diff=arr[i+m-1]-arr[i];
            if(minimum>diff){
                minimum = diff;
            }
        }
        return minimum;
    }
}