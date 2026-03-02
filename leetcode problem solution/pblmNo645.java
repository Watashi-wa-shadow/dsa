//645 Set mismatch
public class pblmNo645 {
    public int[] findErrorNums(int arr[]) {
        int i;
        int n = arr.length;
        //checking if the array element exceed the maximum value of n.
        for(i=0;i<n;i++){
            if(arr[i]>n){
                System.out.println("Enter no upto n and n should be the largest number ");
                return new int[]{-1,-1};
            }
        }
        //calculating frequency.
        int freq[]=new int[n+1];
        int repeating = -1 ;
        int duplicate = -1 ;
        for(i=0;i<n;i++){
                freq[arr[i]]=freq[arr[i]]+1;
        }
        for(i=1;i<=n;i++){
            if(freq[i]>1){
                repeating = i;
            }
            if(freq[i]==0){
                duplicate = i;
            }
        }
        return new int[]{repeating,duplicate};
    }
}
