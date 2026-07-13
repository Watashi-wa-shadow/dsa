//912. Sort an Array
public class pblmNo912 {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }
    private void divide(int[] arr, int si, int ei) {
        if (si >= ei) return;

        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conqueror(arr, si, mid, ei);
    }
    private void conqueror(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                temp[x++] = arr[idx1++];
            } else {
                temp[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            temp[x++] = arr[idx1++];
        }

        while (idx2 <= ei) {
            temp[x++] = arr[idx2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[si + i] = temp[i];
        }
    }
}
