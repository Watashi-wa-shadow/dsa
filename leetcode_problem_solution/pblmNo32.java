//32. Longest Valid Parentheses

import java.util.Stack;

public class pblmNo32{
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int maxLength = 0;
        
        st.push(-1);  
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    int currentLength = i - st.peek();
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }
        
        return maxLength;
    }
}