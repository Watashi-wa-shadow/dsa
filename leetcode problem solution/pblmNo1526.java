//1526. Minimum Number of Increments on Subarrays to Form a Target Array
public class pblmNo1526 {
    public int minNumberOperations(int[] target) {
        int targetSum = target[0];
        for(int i=1;i<target.length;i++){
            if(target[i]>target[i-1])
                targetSum += target[i] - target[i-1];
        }
        return targetSum;
    }
}

