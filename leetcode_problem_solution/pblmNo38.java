//31. Next Permutation
import java.util.*;
public class pblmNo38 {
    public static void nextPermutation(int[] arr) {
        int i,idx=-1,idx2;
        int n=arr.length;
        if(n==0){
            System.out.println("Array is empty ");
            return;
        }
    //finding the index for next permutation.
        for(i = n - 2; i >= 0; i--){
            if(arr[i] < arr[i + 1]){
                idx = i;
                break;
            }
        }
    //if whole array is in descending form we need the ascending array as next permutataion.
        if(idx==-1){
            reverseSuffix(arr, 0, n - 1);
            return ;
        }
    //find the index of largest element.   
        int j=n-1;
        while(arr[j]<=arr[idx]){
            j--;
        }
        idx2=j;
    //swapping the index
        int temp=arr[idx];
        arr[idx]=arr[idx2];
        arr[idx2]=temp;
    //reversing the remaining array.
        reverseSuffix(arr,idx+1,arr.length-1);
    }
    // Reverse part of array
    public static void reverseSuffix(int[] arr, int l, int r){
        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the elements of array ");
            int i;
            for(i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            nextPermutation(arr);
            System.out.println("The next permutation is ");
            for(i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
