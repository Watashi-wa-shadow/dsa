//1963. Minimum Number of Swaps to Make the String Balanced
public class pblmNo1963 {
    public int minSwaps(String s) {
       int balance =0;
       int count  = 0;
       for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ']'){
                if(balance > 0)
                    balance--;
                else
                    count ++;
            }
            else
                balance ++;
       }
       return (count + 1) / 2;
    }
}
