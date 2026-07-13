//242. Valid Anagram
public class pblmNo242 {
    public boolean isAnagram(String str1,String str2) {
        int n1=str1.length();
        int n2=str2.length();
        if(n1<1||n2<1){
            return false;
        }
        if(n1!=n2){
            return false;
        }
        int freq1[]=new int[26];
        int i;
        for(i=0;i<n1;i++){
            //checking the frequency of alphabet.
            //increasing the frequency for str1 and decreasing it for str2.
            freq1[str1.charAt(i)-'a']++;
            freq1[str2.charAt(i)-'a']--;
        }
        for(i=0;i<26;i++){
            //checking if the frquency of alphabtes matches or not.
            if(freq1[i]!=0){
                return false;
            }
        }
       return true;
    }
}
