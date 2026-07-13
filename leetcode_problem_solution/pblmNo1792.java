//1792. Maximum Average Pass Ratio

import java.util.PriorityQueue;

public class pblmNo1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );
        for (int[] c : classes)
            heap.offer(c);
        while (extraStudents-- > 0) {
            int[] c = heap.poll();
            c[0]++;
            c[1]++;
            heap.offer(c);
        }
        double ans = 0;
        while (!heap.isEmpty()) {
            int[] c = heap.poll();
            ans += (double)c[0] / c[1];
        }
        return ans / classes.length;
    }
    
    private double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double)pass / total;
    }

}

