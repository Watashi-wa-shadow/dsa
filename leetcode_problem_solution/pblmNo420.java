//420. Strong Password Checker
public class pblmNo420 {
    public int strongPasswordChecker(String password) {
        boolean lower = false;
        boolean upper = false;
        boolean digit = false;
        int replace = 0 ,ans = 0;
        int missingTypes = 0;
        int n = password.length();
        int i=0;
        if(n<=20){
            replace =0;
            while (i < password.length()){
                char ch = password.charAt(i);
                if(ch >= 'a' && ch <= 'z'){
                    if(!lower){
                        lower = true;
                    }
                }
                if(ch >= 'A' && ch <= 'Z'){
                    if(!upper){
                        upper = true;
                    }
                }
                if(ch >= '0' && ch <= '9'){
                    if(!digit){
                        digit = true;
                    }
                }
                int j = i;
                while (j < password.length() &&
                    password.charAt(j) == password.charAt(i)) {
                    j++;
                }
                int len = j - i;
                if (len >= 3) {
                    replace += len / 3;
                }

                i = j;
            }
            if(!lower){
                missingTypes++;
            }   
            if(!upper){
                missingTypes++;
            }
            if(!digit){
                missingTypes++;
            }   
            if(n<6){
                ans =  Math.max(missingTypes, 6 - n);
            }
            if(n>=6 && n<=20){
                ans =  Math.max(missingTypes, replace);
            }
        }
        else {
            int delete = n - 20;
            replace = 0;
            int one = 0;
            int two = 0;

            while (i < n) {
                char ch = password.charAt(i);

                if (ch >= 'a' && ch <= 'z') lower = true;
                if (ch >= 'A' && ch <= 'Z') upper = true;
                if (ch >= '0' && ch <= '9') digit = true;

                int j = i;
                while (j < n && password.charAt(j) == password.charAt(i)) {
                    j++;
                }

                int len = j - i;

                if (len >= 3) {
                    replace += len / 3;

                    if (len % 3 == 0) one++;
                    else if (len % 3 == 1) two++;
                }

                i = j;
            }

            if (!lower) missingTypes++;
            if (!upper) missingTypes++;
            if (!digit) missingTypes++;

            int use = Math.min(delete, one);
            replace -= use;
            delete -= use;

            use = Math.min(delete / 2, two);
            replace -= use;
            delete -= use * 2;

           replace = Math.max(0, replace - delete / 3);

            ans = (n - 20) + Math.max(missingTypes, replace);
        }

        return ans;
    }
}

