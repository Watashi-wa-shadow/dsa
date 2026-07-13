//2410. Maximum Matching of Players With Trainers

import java.util.Arrays;

public class pblmNo2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int n = players.length;
        int m = trainers.length;
        int j=0,i=0;
        while(i < n && j < m){
            if(players[i]<=trainers[j]){
                count++;
                i++;
                j++;
            }
            else 
                j++;
        }
        return count;
    }
}
