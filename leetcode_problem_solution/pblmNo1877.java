//1877. Minimize Maximum Pair Sum in Array

import java.util.Arrays;

public class pblmNo1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int pairSum = 0;
        for(int i=0;i<n/2;i++){
            pairSum = Math.max(pairSum,(nums[i]+nums[n-i-1]));
        }
        return pairSum;
    }
}
