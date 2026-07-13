//1833. Maximum Ice Cream Bars
public class pblmNo1833 {
    public int maxIceCream(int[] costs, int coins) {
        int freq[] = new int[100001];
        int count=0;
        for(int i =0;i<costs.length;i++){
            freq[costs[i]]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                if(coins-(i*freq[i])>=0){
                        coins-=(i*freq[i]);
                        count+=freq[i];
                    }
                    else if(coins>=0 && coins-(i*freq[i])<0){
                        count+= coins/i;
                        break;
                    }
            }
        }
        return count;
    }
}
