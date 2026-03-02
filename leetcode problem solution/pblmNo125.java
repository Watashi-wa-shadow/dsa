//125. Valid Palindrome
public class pblmNo125 {
    public boolean isPalindrome(String str) {
        int n=str.length();
        if(n<1){
            System.out.println("Invalid string for given task ");
            return false;
        }
        int i=0;
        String str2=str.toLowerCase();
        StringBuilder str3=new StringBuilder();
        while(i<n){
            //Storing alphanumeric character.
            char c=str2.charAt(i);
            if((c>='a'&&c<='z')||(c>='0'&&c<='9')){
                str3.append(c);
            }
            i++;
        }
        int m=str3.length();
        for(i=0;i<m/2;i++){
            //checking palindrome.
            if(str3.charAt(i)!=str3.charAt(m-1-i)){
                return false;
            }
        }
        return true;
    }
}
