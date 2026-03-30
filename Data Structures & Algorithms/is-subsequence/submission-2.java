class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if(s.length() == 0) return true;
        int l = 0;
        int r = 0;
        int cnt = slen;
        while(r<tlen && l<slen){
            if(s.charAt(l) == t.charAt(r)){
                r++;
                l++;
                cnt--;
            } else {
                r++;
            }
            if(cnt==0) return true;
        }
        return false;
    }
}