//2454. Next Greater Element IV

import java.util.Stack;

public class pblmNo2454 {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        Stack<Integer> st1 = new Stack<>(); // waiting for first greater
        Stack<Integer> st2 = new Stack<>(); // waiting for second greater

        for (int i = 0; i < n; i++) {
            //  Resolve second greater
            while (!st2.isEmpty() && nums[st2.peek()] < nums[i]) {
                int index = st2.pop();
                result[index] = nums[i];
            }

            // Move elements that found first greater
            Stack<Integer> temp = new Stack<>();
            while (!st1.isEmpty() && nums[st1.peek()] < nums[i]) {
                temp.push(st1.pop());
            }

            while (!temp.isEmpty()) {
                st2.push(temp.pop());
            }
            //  Current index waits for first greater
            st1.push(i);
        }

        return result;
    }
}
