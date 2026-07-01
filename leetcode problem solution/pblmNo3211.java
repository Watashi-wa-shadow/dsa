//3211. Generate Binary Strings Without Adjacent Zeros

import java.util.ArrayList;
import java.util.List;

public class pblmNo3211 {
    public List<String> validStrings(int n) {
        List<String> list =new ArrayList<>();
        solve(list,n,"",false);
        return list;
    }
    public void solve(List<String> list,int n,String str,boolean val){
        if (str.length() == n) {
            list.add(str);
            return;
        }
        solve(list,n,str+"1",true);
        if(str.length() ==0 || val)
                solve(list,n,str+"0",false);

    }
}
