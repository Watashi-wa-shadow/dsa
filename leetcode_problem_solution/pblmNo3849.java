//3849. Maximum Bitwise XOR After Rearrangement
public class pblmNo3849 {
    public String maximumXor(String s, String t) {
        int countOne=0;
        int countZero = 0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i) == '1')
                countOne++;
            else
                countZero++;
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0' ){
                if(countOne>0){
                    str.append('1');
                    countOne--;
                }
                else{
                    str.append('0');
                    countZero--;
                }
            }
            else{
                if(countZero>0){
                    str.append('1');
                    countZero--;
                }
                else{
                    str.append('0');
                    countOne--;
                }
            }
        }
        return str.toString();
    }
}

