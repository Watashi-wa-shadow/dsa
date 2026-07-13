//2136. Earliest Possible Day of Full Bloom
public class pblmNo2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        mergeSort(plantTime, growTime, 0, plantTime.length - 1);
        int answer =0;
        int currTime =0;
        for(int i = 0;i<plantTime.length;i++){
            currTime += plantTime[i];
            answer = Math.max(answer, currTime + growTime[i]);
        }
        return answer;
    }
    public void mergeSort(int[] plantTime, int[] growTime, int low, int high) {
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(plantTime, growTime, low, mid);
        mergeSort(plantTime, growTime, mid + 1, high);

        merge(plantTime, growTime, low, mid, high);
    }
    public void merge(int[] plantTime, int[] growTime, int low, int mid, int high) {

        int[][] temp = new int[high - low + 1][2];

        int left = low;
        int right = mid + 1;
        int idx = 0;

        while (left <= mid && right <= high) {

            // Descending order of growTime
            if (growTime[left] >= growTime[right]) {
                temp[idx][0] = plantTime[left];
                temp[idx][1] = growTime[left];
                left++;
            } else {
                temp[idx][0] = plantTime[right];
                temp[idx][1] = growTime[right];
                right++;
            }
            idx++;
        }

        while (left <= mid) {
            temp[idx][0] = plantTime[left];
            temp[idx][1] = growTime[left];
            left++;
            idx++;
        }
        while (right <= high) {
            temp[idx][0] = plantTime[right];
            temp[idx][1] = growTime[right];
            right++;
            idx++;
        }

        for (int i = low; i <= high; i++) {
            plantTime[i] = temp[i - low][0];
            growTime[i] = temp[i - low][1];
        }
    }
}

