//670. Maximum Swap
public class pblmNo670 {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        int[] last = new int[10];

        // Store last occurrence of each digit
        for (int i = 0; i < arr.length; i++) {
            last[arr[i] - '0'] = i;
        }

        // Try to improve each digit from left to right
        for (int i = 0; i < arr.length; i++) {
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (last[d] > i) {
                    char temp = arr[i];
                    arr[i] = arr[last[d]];
                    arr[last[d]] = temp;

                    return Integer.parseInt(new String(arr));
                }
            }
        }

        return num;
    }
}

