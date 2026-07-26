//2358. Maximum Number of Groups Entering a Competition
public class pblmNo2385 {
    public int maximumGroups(int[] grades) {
        if(grades.length <= 2)
            return 1;
        int ans = 0,size = 1;
        int remaining = grades.length;
        while(size<=remaining){
            remaining -= size;
            size ++;
            ans++;
        }
        return ans;
    }
}
