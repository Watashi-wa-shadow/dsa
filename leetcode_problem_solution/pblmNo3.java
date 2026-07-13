//3. Longest Substring Without Repeating Characters
public class pblmNo3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] freq = new int[256];

        // initialize with -1
        for (int i = 0; i < 256; i++) {
            freq[i] = -1;
        }

        int left = 0;
        int maxLen = 0;

        // sliding window
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            if (freq[ch] >= left) {
                left = freq[ch] + 1;
            }

            freq[ch] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
