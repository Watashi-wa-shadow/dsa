//841. Keys and Rooms

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pblmNo841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!vis[curr]){
                vis[curr] = true;
                for(int j=0;j<rooms.get(curr).size();j++){
                    q.add(rooms.get(curr).get(j));
                }
            }
        }
        for(int i=0;i<vis.length;i++){
            if(!vis[i] )
                return false;
        }
        return true;
    }
}
