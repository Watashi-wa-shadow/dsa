//5. Longest Palindromic Substring
public class pblmNo5 {
    public String longestPalindrome(String str) {
        int n = str.length();
        if (n < 1) return "";

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {

            // j starts from the longest possible end
            for (int j = n - 1; j > i; j--) {

                // prune smaller lengths
                if (j - i + 1 <= maxLength)
                    break;

                if (isPalindrome(str, i, j)) {
                    start = i;
                    maxLength = j - i + 1;
                    break; // no need to check smaller j
                }
            }
        }
        return str.substring(start, start + maxLength);
    }
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
