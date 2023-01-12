//https://leetcode.com/problems/longest-happy-prefix/description/
class Solution {
    public String longestPrefix(String s) {
        int len = s.length();
        if(len == 1) return "";
        /*

        */
        constructLPS(s);
        return s.substring(0,constructLPS(s));
    }

    private int constructLPS(String s){
        
        int len = s.length();
        int[] lps = new int[len];
        /* 
        lps array is used to keep track of longest suffix at an index j which is also a prefix
        The value of lps[j] represents the number of letters which are equal in suffix and prefix
        */ 
        lps[0] = 0; // lps of 0 will always be zero as no suffix will exist for a length 1;
        int i = 0, j=1;
        /* lps can me constructed in O(n) time*/
        while(j<len){
            if(s.charAt(i)==s.charAt(j)) {
                lps[j] = i+1;
                /* 
                If characters are equal then both i and j will be increamented
                */
                i++;
                j++; 
            } else {
                if(i==0){
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i-1];
                }
            }
        }
        // System.out.println(i);
        // for(int k=0;k<len;k++){
        //     System.out.println(k+" "+lps[k]);
        // }
        return lps[len-1];
    }
}
