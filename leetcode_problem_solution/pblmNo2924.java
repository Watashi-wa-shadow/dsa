//2924. Find Champion II
public class pblmNo2924 {
    public int findChampion(int n, int[][] edges) {
        int inDegree[] = new int[n];
        for(int i=0;i<edges.length;i++){
            inDegree[edges[i][1]]++;
        }
        int champions = -1;
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                if(champions != -1)
                    return -1;
                champions = i;
            }
        }
        return champions;
    }
}
