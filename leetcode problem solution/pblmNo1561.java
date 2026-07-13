//1561. Maximum Number of Coins You Can Get

import java.util.Arrays;

public class pblmNo1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int amount = 0;
        int left = 0;
        for(int i=0;i<n/3;i++){
            amount += piles[n-i-2-left];
            left++;
        }
        return amount;
    }
}

