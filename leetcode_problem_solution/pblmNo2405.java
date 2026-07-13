//2405. Optimal Partition of String

import java.util.HashSet;

public class pblmNo2405 {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!set.contains(ch))
                set.add(ch);
            else{
                count++;
                set.clear();
                set.add(ch);
            }
        }
        count++;
        return count;
    }
}
