//39. Combination Sum

import java.util.ArrayList;
import java.util.List;

public class pblmNo39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = candidates.length;
        List<Integer> list1 = new ArrayList<>();
        combination(candidates,n,target,list1,list,0,0);
        return list;
    }
    public void combination(int candidates[],int n,int target, List<Integer> list1,List<List<Integer>> list,int i,int sum){
        if(sum == target){
            list.add(new ArrayList<>(list1));
            return;
        }
        if(sum>target)
            return;
        for(int j = i;j<n;j++){
            if(sum+candidates[j]<=target){
                list1.add(candidates[j]);
                sum += candidates[j];
                combination(candidates, n, target, list1, list, j, sum);
                sum -= candidates[j];
                list1.remove(list1.size() - 1);
            }
        }
        
    }
}
