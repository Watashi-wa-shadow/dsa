//47. Permutations II

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class pblmNo47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<Integer> list1 = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();       
        boolean vis[] = new boolean[n];
        solve(list1, nums, n, vis,set);
        return new ArrayList<>(set);
    }
     public void solve(List<Integer> list1,int nums[],int n,boolean vis[], HashSet<ArrayList<Integer>> set) {
        if (list1.size() == n) {
            set.add(new ArrayList<>(list1)); 
            return;
        }
        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            vis[i] = true;
            list1.add(nums[i]);
            solve(list1, nums, n, vis,set);
            list1.remove(list1.size() - 1);
            vis[i] = false;
        }
    }
}
