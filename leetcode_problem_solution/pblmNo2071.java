//2071. Maximum Number of Tasks You Can Assign

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class pblmNo2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0;
        int right = Math.min(tasks.length, workers.length);

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canAssign(mid, tasks, workers, pills, strength))
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }

    private boolean canAssign(int k, int[] tasks, int[] workers,
                              int pills, int strength) {

        Deque<Integer> dq = new ArrayDeque<>();

        int j = workers.length - 1;

        for (int i = k - 1; i >= 0; i--) {

            while (j >= workers.length - k &&workers[j] + strength >= tasks[i]) {
                dq.addFirst(workers[j]);
                j--;
            }

            if (dq.isEmpty())
                return false;

            if (dq.peekLast() >= tasks[i]) {
                dq.pollLast();
            } else {
                if (pills == 0)
                    return false;

                pills--;
                dq.pollFirst();
            }
        }

        return true;
    }
}

