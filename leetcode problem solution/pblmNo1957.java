//1957. Delete Characters to Make Fancy String
public class pblmNo1957 {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n < 3) return s;

        char[] arr = s.toCharArray();
        int write = 2; // first two chars are always valid

        for (int read = 2; read < n; read++) {
            // allow if not forming three consecutive equal chars
            if (!(arr[read] == arr[write - 1] && arr[read] == arr[write - 2])) {
                arr[write++] = arr[read];
            }
        }

        return new String(arr, 0, write);
    }
}
