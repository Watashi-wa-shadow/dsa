//2895. Minimum Processing Time

import java.util.Collections;
import java.util.List;

public class pblmNo2895 {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        tasks.sort(Collections.reverseOrder());
        int ans = 0;
        int k=0;
        for(int i=0;i<processorTime.size();i++){
            if(k<tasks.size()){
                int temp = processorTime.get(i);
                int val = Math.max(Math.max(temp + tasks.get(k), temp + tasks.get(k + 1)),Math.max(temp+tasks.get(k + 2),temp+ tasks.get(k + 3)));
                ans = Math.max(ans,val);
                k+=4;
            }
            else
                break;
        }
        return ans;
    }
}
