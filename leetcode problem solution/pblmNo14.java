//14. Longest Common Prefix
public class pblmNo14 {
    public String longestCommonPrefix(String[] str) {
        int n=str.length;
        if(n<1){
            return "";
        }
        int i;
        int size=Integer.MAX_VALUE;
        //changing into lowercase.
        for (i = 0; i < str.length; i++) {
            str[i] = str[i].toLowerCase();
        }
        for(i=0;i<n;i++){
            size = Math.min(size, str[i].length());
        }
        for(i=0;i<size;i++){
            char current = str[0].charAt(i);

            for (int j = 1; j < n; j++){
                //checking for the common prefixes.
                if(str[j].charAt(i)!=current){
                    //if next character does not match with the characters of any string.
                    //program ends here. 
                    return str[0].substring(0, i);
                }
            }
        }
        return str[0].substring(0, size);
    }
}
