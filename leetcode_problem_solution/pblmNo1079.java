//1079. Letter Tile Possibilities

import java.util.Arrays;

public class pblmNo1079 {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        boolean[] vis = new boolean[arr.length];
        return solve(arr, vis, "");
    }

    public int solve(char[] arr, boolean[] vis, String sub) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (vis[i])
                continue;
            if (i > 0 && arr[i] == arr[i - 1] && !vis[i - 1])
                continue;
            vis[i] = true;
            count++;
            count += solve(arr, vis, sub + arr[i]);
            vis[i] = false;  
        }
        return count;
    }
}
