//2294. Partition Array Such That Maximum Difference Is K

import java.util.Arrays;

public class pblmNo2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1,idx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-nums[idx] > k){
                idx =i;
                count++;
            }
        }
        return count;
    }
}

