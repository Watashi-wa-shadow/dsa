//131. Palindrome Partitioning

import java.util.ArrayList;
import java.util.List;

public class pblmNo131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        solve(0,s,curr,ans);
        return ans;
    }
    public void solve(int idx, String s,List<String> curr,List<List<String>> ans){
        if(idx == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < s.length(); i++){

            String sub = s.substring(idx, i + 1);

            if(isPalindrome(sub)){

                curr.add(sub);

                solve(i + 1, s, curr, ans);

                curr.remove(curr.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String temp){
        int n = temp.length();
        for(int i=0;i<n/2;i++){
            if(temp.charAt(i)!=temp.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
