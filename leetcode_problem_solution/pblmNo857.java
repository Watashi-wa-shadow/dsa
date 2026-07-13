//857. Minimum Cost to Hire K Workers

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class pblmNo857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = wage[i];
            arr[i][1] = quality[i];
        }
        Arrays.sort(arr, (a, b) -> Double.compare((double) a[0] / a[1],(double) b[0] / b[1]));
        double amount = Double.MAX_VALUE;
        long sumOfQualities = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            double ratio = (double) arr[i][0] / arr[i][1];
            sumOfQualities+=arr[i][1];
            p.add(arr[i][1]);
            if(p.size()>k)
                sumOfQualities -= p.poll();
            if(p.size() == k)
                amount = Math.min(amount,ratio*sumOfQualities);
        }
        return amount;
    }
}

