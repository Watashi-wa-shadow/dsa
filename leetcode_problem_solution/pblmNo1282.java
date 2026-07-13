//1282. Group the People Given the Group Size They Belong To

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pblmNo1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);

            if (map.get(size).size() == size) {
                ans.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        }

        return ans;
    }
}

