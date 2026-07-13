//946. Validate Stack Sequences

import java.util.Stack;

public class pblmNo946 {
     public boolean validateStackSequences(int arr1[], int arr2[]) {
        if (arr1.length != arr2.length) {
            return false;
        }

        Stack<Integer> st = new Stack<>();
        int j = 0;

        for (int i = 0; i < arr1.length; i++) {
            st.push(arr1[i]);

            while (!st.isEmpty() && st.peek() == arr2[j]) {
                st.pop();
                j++;
            }
        }

        return st.isEmpty();
    }
}
