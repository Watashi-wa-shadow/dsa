//611. Valid Triangle Number

import java.util.Arrays;

public class pblmNo611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int j=0;
        int k=0;
        for(int i=nums.length-1;i>1;i--){
            j=0;
            k=i-1;
            while(j<k){
                if(nums[j]+nums[k]>nums[i]){
                    count = count+k-j;
                    k--;
                }
                else
                j++;
            } 
        }
        return count;
    }
}
