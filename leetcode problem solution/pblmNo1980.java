//1980. Find Unique Binary String

import java.util.HashSet;

public class pblmNo1980 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        String ans = "";
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        String str = solve(n,ans,set);
        return str;
    }
    public String solve(int n,String ans, HashSet<String> set ){
        if(ans.length() == n){
            if(!set.contains(ans))
                return ans;
            return "";
        }
        String left = solve(n,ans + "0",set);
        if(left != "")
            return left;
        
        String right = solve(n,ans + "1",set);
        return right;
    }
}
