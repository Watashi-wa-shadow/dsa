//410. Split Array Largest Sum
public class pblmNo410 {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int maxElement = 0;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            maxElement = Math.max(maxElement, nums[i]);
        }

        int left = maxElement;
        int right = totalSum;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;
                right = mid - 1;   // try smaller maximum sum
            } else {
                left = mid + 1;    // need larger maximum sum
            }
        }
        return ans;
    }
    private boolean canSplit(int[] nums, int k, int maxAllowed) {
        int subarrays = 1;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currSum + nums[i] <= maxAllowed) {
                currSum += nums[i];
            } else {
                subarrays++;
                currSum = nums[i];

                if (subarrays > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
