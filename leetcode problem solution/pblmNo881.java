//881. Boats to Save People

import java.util.Arrays;

public class pblmNo881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i=0,j=people.length-1;
        boolean vis[] = new boolean[people.length];
        while(i<j){
            if(people[i]+people[j]<=limit){
                vis[i] = true;
                vis[j] = true;
                i++;
                j--;
                ans++;
            }
            else{
                ans++;
                vis[j] = true;
                j--;
            }
        }
        for(i=0;i<people.length;i++){
            if(!vis[i])
                ans++;
        }
        return ans;
    }
}

