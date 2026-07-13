//517. Super Washing Machines
public class pblmNo517 {
    public int findMinMoves(int[] machines) {
        int count = 0;
        for(int i=0;i<machines.length;i++){
            count+= machines[i];
        }
        if(count % machines.length != 0)
            return -1;
        count /= machines.length;
        int minCount = 0;
        int ans = 0;
        for(int i=0;i<machines.length;i++){
            int val = machines[i] - count;
            minCount+=val; 
            ans = Math.max(ans, Math.max(Math.abs(minCount), val));

        }
        return ans;
    }
}
