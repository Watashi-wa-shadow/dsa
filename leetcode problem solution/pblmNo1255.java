//1255. Maximum Score Words Formed by Letters
public class pblmNo1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int k = 0,sumOfLetters = 0,totalSum=0;
        int freq[] = new int[26];
        int wordScore[] = new int[words.length];
        for(int i = 0;i< words.length;i++){
            sumOfLetters = 0;
            for(int j = 0;j<words[i].length();j++){
                char ch = words[i].charAt(j);
                sumOfLetters += score[ch - 'a'];
            }
            wordScore[k] = sumOfLetters;
            k++;
        }
        for(int i = 0;i<letters.length;i++){
            char ch =  letters[i];
            freq[ch - 'a']++;
        }
        totalSum = solve(wordScore,freq,totalSum,words,score,0);
        return totalSum;
    }
    public int solve(int wordScore[],int freq[],int totalSum,String[] words, int[] score,int idx){
        if(idx == words.length)
            return totalSum;
        int ans = totalSum;
        for(int i = idx;i<words.length;i++){
            if(wordsCanBePlaced(words[i],freq)){
                totalSum += wordScore[i];
                ans = Math.max(ans,solve(wordScore,freq,totalSum,words,score,i+1));
                totalSum -=  wordScore[i];
                restore(words[i],freq);
            }
        }
        return ans;
    }
    public boolean wordsCanBePlaced(String str,int freq[]){
        for(int i = 0;i<str.length();i++){
        char ch = str.charAt(i);
            if(freq[ch - 'a'] == 0){
                restore(str.substring(0, i),freq);
                return false;
            }
            else{
                freq[ch - 'a']--;
            }
        }
        return true;
    }
    public void restore(String str,int freq[]){
        for(int i = 0;i<str.length();i++){
        char ch = str.charAt(i);
            freq[ch - 'a']++;
        }
    }
}
