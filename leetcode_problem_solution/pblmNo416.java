//416. Partition Equal Subset Sum
public class pblmNo416 {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        dp = new Boolean[nums.length][sum / 2 + 1];
        return solve(nums, sum / 2, 0, 0);
    }
    public boolean solve(int[] nums, int target, int sum, int idx) {
        if (sum == target)
            return true;
        if (sum > target || idx == nums.length)
            return false;
        if (dp[idx][sum] != null)
            return dp[idx][sum];
        if (solve(nums, target, sum + nums[idx], idx + 1))
            return dp[idx][sum] = true;
        if (solve(nums, target, sum, idx + 1))
            return dp[idx][sum] = true;
        return dp[idx][sum] = false;
    }
}
