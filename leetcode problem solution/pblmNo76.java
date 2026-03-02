//76. Minimum Window Substring
public class pblmNo76 {
    public String minWindow(String str, String p) {
        if (str.length() < 1 || str.length() < p.length()) {
            return "";
        }

        int freqStr[] = new int[128];
        int freqP[] = new int[128];

        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i)]++;
        }

        int required = p.length();
        int formed = 0;

        int left = 0, start = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            freqStr[ch]++;

            if (freqStr[ch] <= freqP[ch]) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = str.charAt(left);
                freqStr[leftChar]--;

                if (freqStr[leftChar] < freqP[leftChar]) {
                    formed--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : str.substring(start, start + minLen);
    }
}
