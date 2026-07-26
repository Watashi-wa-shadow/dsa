//2517. Maximum Tastiness of Candy Basket

import java.util.Arrays;

public class pblmNo2517 {
    public int maximumTastiness(int[] price, int k) {
        if(k == 1)
            return 0;
        int n = price.length;
        if(n == 2)
            return Math.abs(price[1] - price[0]);
        Arrays.sort(price);
        int low = 0;
        int high = price[n-1] - price[0];
        return search(price,low,high,k);
    }
    public int search(int price[],int low,int high,int k){
        if(low>high)
            return high;
        int mid = low + (high-low)/2;
        if (possible(price, mid, k)) {
            return search(price, mid + 1, high, k);
        } 
        else {
            return search(price, low, mid - 1, k);
        }
    }
    public boolean possible(int[] price, int diff, int k) {
        int count = 1;
        int last = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] - last >= diff) {
                count++;
                last = price[i];
            }
        }
        return count>=k;
    }
}
