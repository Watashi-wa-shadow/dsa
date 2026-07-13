//153. Find Minimum in Rotated Sorted Array
public class pblmNo153 {
    public int findMin(int arr[]) {
        if (arr == null || arr.length == 0) {
        System.out.println("Array is empty");
        return -1;
        }
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }
}
