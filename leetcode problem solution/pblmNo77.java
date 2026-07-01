//77. Combinations

import java.util.ArrayList;
import java.util.List;

public class pblmNo77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        solve(list,list1,n,k,1);
        return list;
    }
    public void solve(List<List<Integer>> list,List<Integer> list1,int n,int k,int start) {
        if (list1.size() == k) {
            list.add(new ArrayList<>(list1));
            return;
        }
        for (int i = start; i <=n; i++) {
            list1.add(i);
            solve(list, list1, n,k,i+1);
            list1.remove(list1.size() - 1);
        }
    }
}
