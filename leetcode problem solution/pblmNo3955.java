//3955. Valid Binary Strings With Cost Limit

import java.util.ArrayList;
import java.util.List;

public class pblmNo3955 {
    public List<String> generateValidStrings(int n, int k) {
        List<String> list = new ArrayList<>();
        String str = "";
        boolean val = false;
        solve(list,str,n,k,0,0,val);
        return list;
    }
    public void solve(List<String> list,String str,int n,int k,int cost,int pos,boolean val){
        if(str.length() == n){
            list.add(str);
            return;
        }
        solve(list,str +"0",n,k,cost,pos+1,false);
        if(cost+pos <= k && !val){
            solve(list,str + "1",n,k,cost+pos,pos+1,true);
        }
    }
}
