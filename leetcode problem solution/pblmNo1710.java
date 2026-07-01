//1710. Maximum Units on a Truck
public class pblmNo1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        mergeSort(boxTypes, 0, boxTypes.length - 1);
        int totalUnits = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize == 0)
                break;
            int boxes = Math.min(boxTypes[i][0], truckSize);
            totalUnits += boxes * boxTypes[i][1];
            truckSize -= boxes;
        }
        return totalUnits;
    }
    public void mergeSort(int[][] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public void merge(int[][] arr, int low, int mid, int high) {
        int[][] temp = new int[high - low + 1][2];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            // Descending order of units per box
            if (arr[left][1] >= arr[right][1]) {
                temp[k][0] = arr[left][0];
                temp[k][1] = arr[left][1];
                left++;
            } else {
                temp[k][0] = arr[right][0];
                temp[k][1] = arr[right][1];
                right++;
            }
            k++;
        }
        while (left <= mid) {
            temp[k][0] = arr[left][0];
            temp[k][1] = arr[left][1];
            left++;
            k++;
        }
        while (right <= high) {
            temp[k][0] = arr[right][0];
            temp[k][1] = arr[right][1];
            right++;
            k++;
        }
        for (int i = 0; i < temp.length; i++) {
            arr[low + i][0] = temp[i][0];
            arr[low + i][1] = temp[i][1];
        }
    }
}
