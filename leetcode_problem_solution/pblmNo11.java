//11. Container With Most Water
public class pblmNo11 {
    public int maxArea(int[] height) {
        int n=height.length;
        if(n<2){
            System.out.println("Maximum amount of water cannot be found ");
            return -1;
        }
        int maxWater=0;
        int left=0;
        int right=n-1;
        while(left<right){
            //finding the area of water and comparing it with the max vlaue stored.
            int temp=Math.min(height[left],height[right])*(right-left);
            maxWater=Math.max(maxWater,temp);
            //checking which side should be change in order to obtain the new area for comparison.
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxWater;
    }
}
