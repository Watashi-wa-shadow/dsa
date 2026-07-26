//781. Rabbits in Forest

import java.util.HashMap;

public class pblmNo781{
    public int numRabbits(int[] answers) {
        if(answers.length == 1)
            return answers[0]+1;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int num : answers) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }
        int ans = 0;
        for (int key : freq.keySet()) {
            int value = freq.get(key);
            int groupSize = key +1;
            if (groupSize >= value) {
                ans = ans + groupSize;
            }
            else{
                if(value % groupSize == 0){
                    int temp = value/groupSize;
                    ans = ans + (temp*groupSize) ;
                }
                else{
                    int temp = value/groupSize;
                    ans = ans + ((temp+1)*groupSize) ;
                } 
            }
        }
        return ans;
    }
}
