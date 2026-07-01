//216. Combination Sum III

import java.util.ArrayList;
import java.util.List;

public class pblmNo216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        combination(k,n,list1,list,1,0);
        return list;
    }
     public void combination(int k,int target,List<Integer> list1,List<List<Integer>> list,int i,int sum){
        if(sum == target && list1.size() == k){
            list.add(new ArrayList<>(list1));
            return;
        }
        if(sum>target )
            return;
        for(int j=i;j<=9;j++){
            if(sum+j<=target){
                sum+= j;
                list1.add(j);
                combination(k,target,list1,list,j+1,sum);
                sum-= j;
                list1.remove(list1.size() - 1);
            }
        }
    }
}
