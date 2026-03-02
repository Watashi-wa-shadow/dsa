//1122. Relative Sort Array
public class pblmNo1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int count[] = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            int val = arr2[i];
            for (int j = 0; j < count[val]; j++) {
                arr1[idx++] = val;
            }
            count[val] = 0; 
        }
        for (int val = 0; val < count.length; val++) {
            for (int j = 0; j < count[val]; j++) {
                arr1[idx++] = val;
            }
        }
        return arr1;
    }
}
