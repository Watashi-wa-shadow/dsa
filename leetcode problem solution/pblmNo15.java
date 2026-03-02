//15 3SUM

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pblmNo15 {
    public List<List<Integer>> threeSum(int arr[]) {
         List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        if (n < 3) return result;

        // sort array (merge sort removed)
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {

            // skip duplicate i
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));

                    // skip duplicates for left and right
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
