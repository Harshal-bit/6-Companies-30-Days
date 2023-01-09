// https://leetcode.com/problems/bulls-and-cows/

class Solution {
    public String getHint(String secret, String guess) {
        int [] map = new int[10];
        for(int i=0 ; i<secret.length();i++){
            map[secret.charAt(i)-'0']++;
        }
        
        int bulls=0;
        int cows =0;
        for(int i =0;i<guess.length();i++){
            if(map[guess.charAt(i)-'0'] != 0){
                cows++;
                map[guess.charAt(i)-'0']--;
            }
        }
        for(int i=0;i<guess.length();i++){
           if(secret.charAt(i)==guess.charAt(i)) bulls++;
        }
        return (bulls+"A"+(cows-bulls)+"B");
    }
}
