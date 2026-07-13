//765. Couples Holding Hands
public class pblmNo765 {
    public int minSwapsCouples(int[] row) {
        int count = 0;
        int partner = 0;
        int[] pos = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            pos[row[i]] = i;
        }
        for(int i=0;i<row.length;i += 2){
            partner = row[i] ^ 1;
            int partnerPos = pos[partner];
            if(row[i+1] == partner)
                continue;
            else{
                int temp = row[i + 1];
                row[i + 1] = row[partnerPos];
                row[partnerPos] = temp;

                // Update positions
                pos[temp] = partnerPos;
                pos[partner] = i + 1;
                count++;
            }
        }
        return count;
    }
}

