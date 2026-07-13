//1665. Minimum Initial Energy to Finish Tasks

import java.util.Arrays;

public class pblmNo1665 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) ->
            Integer.compare((b[1] - b[0]), (a[1] - a[0]))
        ); 
        int initialEnergy = 0;
        int currentEnergy = 0;
        for(int i = 0;i<tasks.length;i++){
            if(currentEnergy < tasks[i][1]){
                int value = tasks[i][1] - currentEnergy;
                initialEnergy += value;
                currentEnergy += value;
            }
            currentEnergy -= tasks[i][0];
        }
        return initialEnergy;
    }
}
