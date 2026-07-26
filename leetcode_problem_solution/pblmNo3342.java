//3342. Find Minimum Time to Reach Last Room II

import java.util.PriorityQueue;

public class pblmNo3342 {
    class pair{
        int time,row,col,parity;
        pair(int time,int row,int col,int parity){
            this.time = time;
            this.row = row;
            this.col = col;
            this.parity = parity;
        }
    } 
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][][] dist = new int[n][m][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j][2] = Integer.MAX_VALUE;
                dist[i][j][1] = Integer.MAX_VALUE;
            }
        }
        dist[0][0][1] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new pair(0,0,0,1));
        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int time = curr.time;
            int row = curr.row;
            int col = curr.col;
            int parity = curr.parity;
            int newTime;
            if(curr.time > dist[curr.row][curr.col][curr.parity ])
                continue;
            if(row == n-1 && col == m-1)
                return time;
            if(row>=0 && row<n){
                if(col >0 ){
                    newTime = Math.max(time,moveTime[row][col - 1]) + parity;
                    int nextParity = (parity == 1) ? 2 : 1;
                    if(newTime < dist[row][col -1][nextParity]){
                        dist[row][col - 1][nextParity] = newTime;
                        pq.offer(new pair(newTime,row,col - 1,nextParity));
                    }
                }
                if(col <m-1 ){
                    newTime = Math.max(time,moveTime[row][col + 1]) + parity;
                    int nextParity = (parity == 1) ? 2 : 1;
                    if(newTime < dist[row][col +1][nextParity]){
                        dist[row][col + 1][nextParity] = newTime;
                        pq.offer(new pair(newTime,row,col + 1,nextParity));
                    }
                }
            }
            if(col>=0 && col <m){
                if(row >0 ){
                newTime = Math.max(time,moveTime[row -1 ][col]) + parity;
                int nextParity = (parity == 1) ? 2 : 1;
                    if(newTime < dist[row - 1][col][nextParity]){
                        dist[row -1 ][col][nextParity] = newTime;
                        pq.offer(new pair(newTime,row - 1,col,nextParity));
                    }
                }
                if(row < n-1 ){
                newTime = Math.max(time,moveTime[row +1 ][col]) + parity;
                int nextParity = (parity == 1) ? 2 : 1;
                    if(newTime < dist[row + 1][col][nextParity]){
                        dist[row +1 ][col][nextParity] = newTime;
                        pq.offer(new pair(newTime,row + 1,col,nextParity));
                    }
                }
            }
        }
        return -1;
    }
}
