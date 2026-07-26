//1962. Remove Stones to Minimize the Total

import java.util.Collections;
import java.util.PriorityQueue;

public class pblmNo1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<piles.length;i++)
            q.offer(piles[i]);
        while(k>0){
            int temp = q.poll();
            q.offer((temp + 1) / 2);
            k--;
        }
        int ans = 0;
        while(!q.isEmpty()){
            ans += q.poll();
        }
        return ans;
    }
}
