class Solution {
    public String longestPalindrome(String s) {
        int resStart = 0;
        int resEnd = 0;
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > maxlen){
                    resStart = l;
                    resEnd = r + 1;
                    maxlen++;
                }
                l--;
                r++;
            }
            // even length
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > maxlen){
                    resStart = l;
                    resEnd = r+1;
                    maxlen++;
                }
                l--;
                r++;
            }
        }
        return s.substring(resStart, resEnd);
    }
}
