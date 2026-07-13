//152 Maximum Product Subarray
public class pblmNo152 {
    public int maxProduct(int arr[]) {
        if(arr.length==0){
            return 0;
        }
        int maxProduct=arr[0];
        int result=arr[0];
        int minProduct=arr[0];
        for(int i=1;i<arr.length;i++){
            int res=arr[i];
            if(res<0){
        // swapping is necessary because a small negative number multiplied by another negative number can become a large positive number.
                int temp=maxProduct;
                maxProduct=minProduct;
                minProduct=temp;
            }
            minProduct=Math.min(minProduct*res,res);
            maxProduct=Math.max(maxProduct*res,res);
            result=Math.max(result,maxProduct);
        }
        
        return result;
    }
}
