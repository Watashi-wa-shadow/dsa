//46. Permutations

import java.util.ArrayList;
import java.util.List;

public class pblmNo46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        List<Integer> list1 = new ArrayList<>();
        boolean vis[] = new boolean[n];
        solve(list, list1, nums, n, vis);
        return list;
    }
     public void solve(List<List<Integer>> list,List<Integer> list1,int nums[],int n,boolean vis[]) {
        if (list1.size() == n) {
            list.add(new ArrayList<>(list1));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            vis[i] = true;
            list1.add(nums[i]);
            solve(list, list1, nums, n, vis);
            list1.remove(list1.size() - 1);
            vis[i] = false;
        }
    }
}
