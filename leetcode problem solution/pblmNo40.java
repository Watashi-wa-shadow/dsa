//40. Combination Sum II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pblmNo40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        List<Integer> list1 = new ArrayList<>();
        combination(candidates,n,target,list1,list,0,0);
        return list;
    }
    public void combination(int candidates[],int n,int target,List<Integer> list1,List<List<Integer>> list,int i,int sum){
        if(sum == target){
            list.add(new ArrayList<>(list1));
            return;
        }
        if(sum>target )
            return;
        for(int j=i;j<n;j++){
            if(j > i && candidates[j] == candidates[j - 1])
                continue;
            if(sum+candidates[j]<=target){
                sum+= candidates[j];
                list1.add(candidates[j]);
                combination(candidates,n,target,list1,list,j+1,sum);
                sum-= candidates[j];
                list1.remove(list1.size() - 1);
            }
        }
    }
}
