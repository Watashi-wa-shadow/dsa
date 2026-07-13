//90. Subsets II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class pblmNo90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  
        List<Integer> list = new ArrayList<>();
        HashSet<List<Integer>> list1 = new HashSet<>();
        solve(0, nums, list,list1);
        return new ArrayList<>(list1);
    }
     public void solve(int idx, int[] nums,List<Integer> curr,HashSet<List<Integer>> ans) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        solve(idx + 1, nums, curr, ans);
        curr.remove(curr.size() - 1);
        solve(idx + 1, nums, curr, ans);
    }
}
