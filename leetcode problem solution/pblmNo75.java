//75. Sort Colors
public class pblmNo75 {
    public void sortColors(int arr[]) {
        int n = arr.length;
        if (n == 0) return;

        // Find the largest number first to size the frequency array
        int largestNumber = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largestNumber) {
                largestNumber = arr[i];
            }
        }

        // Create frequency array based on the MAX value
        int[] count = new int[largestNumber + 1];

        //  Count frequency
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Rebuild the original array
        int index = 0;
        for (int i = 0; i <= largestNumber; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
}
