//20. Valid Parentheses
public class pblmNo20 {
    public boolean isValid(String str) {
        int n=str.length();
        if(n<1){
            return false;
        }
        //if the size of string is odd parenthesis can never be matched.
        if((n%2)!=0){
            return false;
        }
        int i=0;
        StringBuilder str1=new StringBuilder();
        while(i<n){
            char c=str.charAt(i);
            if(c == '(' || c == '{' || c == '[' ){
                str1.append(c);
            }
            else{
                //for every closing brackets checking their opening brackets.
                if(str1.length()==0){
                    return false;
                }
                char c1=str1.charAt(str1.length()-1);
                if((c == ')' && c1=='(') || (c == '}' && c1=='{') || ( c == ']' && c1=='[') ){
                    str1.deleteCharAt(str1.length()-1);
                }
                else{
                    return false;
                }
            }
            i++;
        }
        //checking if the there is any opening brackets left or not.
        return str1.length() == 0;
    }
}
