//78. Subsets

import java.util.ArrayList;
import java.util.List;

public class pblmNo78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> list1 = new ArrayList<>();
        solve(0, nums, list,list1);
        return list1;
    }
    public void solve(int idx, int[] nums,List<Integer> curr,List<List<Integer>> ans) {

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
