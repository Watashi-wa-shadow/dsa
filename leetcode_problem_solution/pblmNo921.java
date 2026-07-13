//921. Minimum Add to Make Parentheses Valid
public class pblmNo921 {
    public int minAddToMakeValid(String s) {
        return solve(s,0,0,0);
        
    }
    public int solve(String s, int idx, int open, int add) {
        if (idx == s.length())
            return open + add;

        if (s.charAt(idx) == '(')
            return solve(s, idx + 1, open + 1, add);

        if (open > 0)
            return solve(s, idx + 1, open - 1, add);

        return solve(s, idx + 1, open, add + 1);
    }
}
