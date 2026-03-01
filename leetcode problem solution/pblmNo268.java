//268 MISSING numbers

public class pblmNo268 {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        if(n == 0){
            System.out.println("Array is empty ");
            return -1;
        }
        int totalSum = (n*(n+1))/2;
        int currSum = 0;
        for(int i=0;i<n;i++){
                if(arr[i] < 0 || arr[i] > n){
                        System.out.println("Invalid element present in array");
                        return -1;
                }
                currSum += arr[i];
        }
        return totalSum - currSum; 
    }
}
