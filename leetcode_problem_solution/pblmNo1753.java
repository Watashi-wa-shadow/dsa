//1753. Maximum Score From Removing Stones

import java.util.Collections;
import java.util.PriorityQueue;

public class pblmNo1753 {
    public int maximumScore(int a, int b, int c) {
        int count = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.add(a);
        q.add(b);
        q.add(c);
        while(true){
            int x = q.poll();
            int y = q.poll();
            if(y==0)
                break;
            count ++;
            x--;
            y--;
            q.add(x);
            q.add(y);
        }
        return count;
    }
}
