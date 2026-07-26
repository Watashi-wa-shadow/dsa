//3341. Find Minimum Time to Reach Last Room I

import java.util.Arrays;
import java.util.PriorityQueue;

public class pblmNo3341 {
    class Pair {
        int time;
        int row;
        int col;

        Pair(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        int n = moveTime.length;
        int m = moveTime[0].length;
        int dist[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int time = curr.time;
            int row = curr.row;
            int column  = curr.col;
            int newTime = 0;
            if(curr.time > dist[curr.row][curr.col])
                continue;
            if(row == n-1 && column == m-1)
                return time;
            if(row>=0 && row<n){
                if(column<m-1){
                    newTime = Math.max(time,moveTime[row][column + 1])+1;
                    if(newTime < dist[row][column + 1]){
                        dist[row][column + 1] = newTime;
                        pq.offer(new Pair(newTime, row, column + 1));
                    }     
                }
                if(column>0){
                    newTime = Math.max(time,moveTime[row][column - 1])+1;
                    if(newTime < dist[row][column - 1]){
                        dist[row][column - 1] = newTime;
                        pq.offer(new Pair(newTime, row, column - 1));
                    } 
                }
            }
            if(column>=0 && column<m){
                if(row< n-1){
                    newTime = Math.max(time,moveTime[row + 1][column]) +1;
                    if(newTime < dist[row + 1][column]){
                        dist[row + 1][column] = newTime;
                        pq.offer(new Pair(newTime, row + 1, column));
                    } 
                }
                if(row >0){
                    newTime = Math.max(time,moveTime[row - 1][column]) + 1;
                    if(newTime < dist[row - 1][column]){
                        dist[row - 1][column] = newTime;
                        pq.offer(new Pair(newTime, row - 1, column));
                    } 
                }
            }
        }
        return -1;
    }
}
