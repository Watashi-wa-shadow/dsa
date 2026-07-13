//2966. Divide Array Into Arrays With Max Difference

import java.util.Arrays;

public class pblmNo2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean value = true;
        int arr[][] = new int[n/3][3];
        for(int i=0;i<n;i=i+3){
            if(nums[i+2]-nums[i] > k) {
                value = false;
                break;
            }
        }
        if(!value)
            return new int[][]{};
        int x=0;
        for(int i=0;i<n/3;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = nums[x];
                x++;
            }
        }
        return arr;
    }
}

