//647. Palindromic Substrings
public class pblmNo647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            // odd length palindromes
            count += expandFromCenter(s, i, i);

            // even length palindromes
            count += expandFromCenter(s, i, i + 1);
        }
        return count;
    }
    private int expandFromCenter(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
