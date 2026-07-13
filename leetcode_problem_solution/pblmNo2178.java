//2178. Maximum Split of Positive Even Integers

import java.util.ArrayList;
import java.util.List;

public class pblmNo2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        long count = 2;
        if(finalSum % 2 == 0){
            for(long i = 0;i< finalSum/2;i++){
                if((finalSum - count) > count){
                    list.add(count);
                    finalSum -= count;
                    count += 2;
                }
                else{
                    list.add(finalSum);
                    break;
                }
            }
        }
        return list;
    }
}
