class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;
        int slen = s.length();
        int tlen = t.length();
        int cnt = 0;
        while(i<slen && j<tlen){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else {
                i++;
            }
            cnt = j;
        }
        return tlen - cnt;
    }
}