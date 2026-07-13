//773. Sliding Puzzle

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class pblmNo773 {
     public int slidingPuzzle(int[][] board) {
        String start = "";

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start += board[i][j];
            }
        }
        return solve(start);
    }
    public int solve(String start) {

        String target = "123450";

        int[][] moves = {
            {1, 3}, //index 0
            {0, 2, 4}, //index 1
            {1, 5}, // index 2
            {0, 4}, // index 3
            {1, 3, 5}, // index 4
            {2, 4} //index 5
        };

        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();

        q.offer(start);
        vis.add(start);
        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();

                if (curr.equals(target)) {
                    return steps;
                }

                int zero = curr.indexOf('0');

                char[] arr = curr.toCharArray();

                for (int j = 0; j < moves[zero].length; j++) {

                    int next = moves[zero][j];

                    swap(arr, zero, next);

                    String newState = new String(arr);

                    if (!vis.contains(newState)) {
                        vis.add(newState);
                        q.offer(newState);
                     }

                    swap(arr, zero, next); // restore original state
                }
            }

            steps++;
        }

        return -1;
    }

    public void swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
