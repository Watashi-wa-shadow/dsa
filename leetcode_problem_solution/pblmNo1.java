//1. Two Sum
public class pblmNo1 {
    public int[] twoSum(int[] nums, int target) {
        int i,j;
        int arr[] = new int[2];
        if(nums.length == 0) return arr;
        for(i=0; i<nums.length-1; i++ ){
            for(j=i+1;j<nums.length;j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
    arr[0] = arr[1] = -1;
    return arr;
    }
    
}
