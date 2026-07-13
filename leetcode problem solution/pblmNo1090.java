//1090. Largest Values From Labels

import java.util.Arrays;

public class pblmNo1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int m = 0;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
            if(labels[i]>m){
                m=labels[i];
            }
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));
        int freq[] = new int[m+1];
        int ans=0,i=0;
        while(numWanted>0 && i<n){
            if(freq[arr[i][1]]<useLimit){
                ans+=arr[i][0];
                freq[arr[i][1]]++;
                numWanted--;
            }
            i++;
        }
        return ans;
    }
}

