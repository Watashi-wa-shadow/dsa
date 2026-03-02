//33  Search in Rotated Sorted Array
public class pblmNo33 {
    public int search(int arr2[], int target) {
        int left = 0, right = arr2.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr2[mid] == target)
                return mid;

            // Left half sorted
            if (arr2[left] <= arr2[mid]) {
                if (target >= arr2[left] && target < arr2[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // Right half sorted
            else {
                if (target > arr2[mid] && target <= arr2[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

    return -1; // target not found
    }
}
