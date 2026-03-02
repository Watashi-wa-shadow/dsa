//424. Longest Repeating Character Replacement
public class pblmNo424 {
    public int characterReplacement(String str, int k) {
        if(str.length()<1){
            return -1;
        }
        String str1 = str.toUpperCase();
        int n = str1.length();
        int freq[] = new int[26];
        int right;
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;
        for(right=0;right<n;right++){
            char ch = str1.charAt(right);
            //counting frequency
            if(ch >= 'A' && ch <= 'Z'){
                freq[ch - 'A']++;
                maxCount = Math.max(maxCount, freq[ch - 'A']);
            }
            //Assume the string as a sliding window.
            //Sliding the window fron left to right to find out the part which will be changed. 
            while((right-left+1)-maxCount>k){
                char leftchar=str1.charAt(left);
                freq[leftchar-'A']--;
                left++;
            }
            maxLength=Math.max(maxLength,(right-left+1));
        }
        return maxLength;
    }
}
