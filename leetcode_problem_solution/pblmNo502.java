//502. IPO

import java.util.Arrays;
import java.util.PriorityQueue;

public class pblmNo502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int arr[][] = new int[profits.length][2];
        int j=0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<profits.length;i++){
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        while(k>0){
            while(j < profits.length && w>=arr[j][0]){
                heap.add(arr[j][1]);
                j++;
            }
            if(heap.isEmpty())
                break;
            w+=heap.poll();
            k--;
        }
        return w;
    }
}
