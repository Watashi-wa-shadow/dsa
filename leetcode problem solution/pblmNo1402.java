//1402. Reducing Dishes

import java.util.Arrays;

public class pblmNo1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        if (n == 0 || satisfaction[n-1]<=0)
            return 0;
        int idx = n-1, x = 1;
        int currSum = satisfaction[n - 1];
        int answer = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (satisfaction[i] + currSum > 0) {
                currSum += satisfaction[i];
                idx = i;
            } else {
                break;
            }
        }
        for (int i = idx; i < n; i++) {
            answer += x * satisfaction[i];
            x++;
        }
        return answer;
    }
}

