//3219. Minimum Cost for Cutting Cake II

import java.util.Arrays;

public class pblmNo3219 {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        for (int l = 0, r = horizontalCut.length - 1; l < r; l++, r--) {
            int temp = horizontalCut[l];
            horizontalCut[l] = horizontalCut[r];
            horizontalCut[r] = temp;
        }
        Arrays.sort(verticalCut);
        for (int l = 0, r = verticalCut.length - 1; l < r; l++, r--) {
            int temp = verticalCut[l];
            verticalCut[l] = verticalCut[r];
            verticalCut[r] = temp;
        }
        int horizontalCount = 1;
        int verticalCount = 1;
        long ans = 0;
        int i=0,j=0;
       while (i < horizontalCut.length && j < verticalCut.length){
            if(horizontalCut[i]> verticalCut[j]){
                long val = (long)horizontalCut[i]*verticalCount;
                ans += val;
                i++;
                horizontalCount++;
            }
            else{
                long val =(long) verticalCut[j]* horizontalCount;
                ans+=val;
                j++;
                verticalCount++;
            }
        }
        while(i< horizontalCut.length){
            long val = (long)horizontalCut[i]*verticalCount;
            ans += val;
            i++;
            horizontalCount++;
        }
        while(j < verticalCut.length){
            long val =(long) verticalCut[j]* horizontalCount;
            ans+=val;
            j++;
            verticalCount++;
        }
        return ans;
    }
}

