//387. First Unique Character in a String
public class pblmNo387 {
    public int firstUniqChar(String s) {
         int[] freq = new int[26];
         // counting frequencies
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Finding first character with freq = 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
