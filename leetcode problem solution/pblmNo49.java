//49. Group Anagrams

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pblmNo49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String str = strs[i];
            int[] freq = new int[26];

            for (int j = 0; j < str.length(); j++) {
                freq[str.charAt(j) - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                key.append('#');
                key.append(freq[k]);
            }

            if (!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<>());
            }

            map.get(key.toString()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
