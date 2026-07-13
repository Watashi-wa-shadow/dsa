//134. Gas Station
public class pblmNo134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int totalgas = 0;
        int mingas = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];

            totalgas += diff;
            mingas += diff;

            if(mingas < 0){
                start = i + 1;
                mingas = 0;
            }
        }

        if(totalgas < 0){
            return -1;
        }

        return start;
    }
}
