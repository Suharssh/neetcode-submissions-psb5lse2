class Solution {
    public boolean validPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r)){
                String str = s.substring(l+1,r+1);
                String str2 = s.substring(l,r);
                if(isPalindrome(str) == false && isPalindrome(str2) == false) return false;
                else return true;
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean isPalindrome(String str){
        int l = 0;
        int r = str.length()-1;
        while(l<=r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}