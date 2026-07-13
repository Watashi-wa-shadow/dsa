//55. Jump Game
public class pblmNo55 {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if (i > maxReach)
                return false;
            maxReach = Math.max(maxReach,i+val);
            if(maxReach >= nums.length-1)
                return true;
        }
        return true;
    }
}
