//826. Most Profit Assigning Work

import java.util.Arrays;

public class pblmNo826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // ascending by difficulty
        Arrays.sort(worker);

        int maxProfitSoFar = 0, ans = 0, j = 0;
        for (int w : worker) {
            while (j < n && jobs[j][0] <= w) {
                maxProfitSoFar = Math.max(maxProfitSoFar, jobs[j][1]);
                j++;
            }
            ans += maxProfitSoFar;
        }
        return ans;
    }
}
