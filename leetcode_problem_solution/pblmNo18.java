//18. 4Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pblmNo18 {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        if (n < 4) return result;

        Arrays.sort(arr); // replacing your quickSort

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // skip duplicate i

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue; // skip duplicate j

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];

                    if (sum == target) {
                        result.add(Arrays.asList(
                            arr[i], arr[j], arr[k], arr[l]
                        ));

                        k++;
                        l--;

                        while (k < l && arr[k] == arr[k - 1]) k++; // skip k duplicates
                        while (k < l && arr[l] == arr[l + 1]) l--; // skip l duplicates
                    } 
                    else if (sum > target) {
                        l--;
                    } 
                    else {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
