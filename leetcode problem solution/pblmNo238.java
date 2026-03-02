//238. Product of Array Except Self
public class pblmNo238 {
    public int[] productExceptSelf(int arr[]) {
        int n=arr.length;
        int output[]=new int[n];
        int i;
        if(n==0){
            System.out.println("The array is empty ");
            return null;
        }
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        //Calculating prefix.
        prefix[0]=1;
        for(i=1;i<n;i++){
            prefix[i]=arr[i-1]*prefix[i-1];
        }
        //Calculating suffix.
        suffix[n-1]=1;
        for(i=n-2;i>=0;i--){
            suffix[i]=arr[i+1]*suffix[i+1];
        }
        for(i=0;i<n;i++){
            output[i]=prefix[i]*suffix[i];
        }
        return output;
    }
}
