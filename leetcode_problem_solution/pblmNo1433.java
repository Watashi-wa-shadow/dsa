//1433. Check If a String Can Break Another String

import java.util.Arrays;

public class pblmNo1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0;
        while(i<a.length){
            if(a[i] != b[i])
                break;
            i++;
        }
        if(i == a.length)
            return true;
        if(a[i] > b[i]){
            for(int idx = i;idx<a.length;idx++){
            if(a[idx] < b[idx])
                return false;
            }
        }  
        else{
            for(int idx = i;idx<a.length;idx++){
            if(a[idx] > b[idx])
                return false;
            }
        }
        return true;
    }
}
