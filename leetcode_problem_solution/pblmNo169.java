//169. Majority Element

import java.util.Arrays;

public class pblmNo169 {
     public int majorityElement(int[] nums) {
        
        // Sort the array
        Arrays.sort(nums);

        // Majority element is always at middle index
        return nums[nums.length / 2];
    }
}
