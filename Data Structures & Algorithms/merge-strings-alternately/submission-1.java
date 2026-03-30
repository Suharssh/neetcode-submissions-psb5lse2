class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l = 0;
        int r = 0;
        String res = "";
        while(l<word1.length() && r < word2.length()){
            res+=word1.charAt(l++);
            res+=word2.charAt(r++);
        }
        while(l < word1.length()){
            res+=word1.charAt(l++);
        }
        while(r < word2.length()){
            res+=word2.charAt(r++);
        }
        return res;
    }
}