//45. Jump Game II
public class pblmNo45 {
    public int jump(int[] nums) {
        int maxReach = 0;
        int count = 0;
        int currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currentEnd) {
                count++;
                currentEnd = maxReach;
            }
        }

        return count;
    }
}
