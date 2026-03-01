//53 MAXIMUM SUBARRAY

import java.util.*;
public class pblmNo53 {
    public static int maxSubArray(int arr[]) {
        if (arr.length == 0) {
        return 0;
    }

    int maxSum = arr[0];
    int currentSum = arr[0];

    for (int i = 1; i < arr.length; i++) {
        currentSum = Math.max(arr[i], currentSum + arr[i]);
        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int i;
            System.out.println("Enter the size of an array ");
            int n=sc.nextInt();
            System.out.println("Enter the elements of an array ");
            int arr[]=new int[n];
            for(i=0;i<n;i++){
                arr[i]=sc.nextInt();
            } 
           System.out.println("The sum of maximum subarray is  "+maxSubArray(arr));
        }
    }
}
