//581. Shortest Unsorted Continuous Subarray
public class pblmNo581 {
    public int findUnsortedSubarray(int[] arr) {
         int n = arr.length;
        if (n == 0) return 0;

        int left = 0;
        int right = n - 1;

        // find first index where order breaks
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // already sorted
        if (left == n - 1) {
            return 0;
        }

        // find last index where order breaks
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // NEW PART (core LC 581 logic)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        // expand left boundary
        while (left > 0 && arr[left - 1] > min) {
            left--;
        }

        // expand right boundary
        while (right < n - 1 && arr[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
}
