//1798. Maximum Number of Consecutive Values You Can Make

import java.util.Arrays;

public class pblmNo1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 1;
        int i=0;
        while(i<coins.length){
            if(coins[i]<=ans){
                ans += coins[i];
                i++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}
