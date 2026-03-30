class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int m = abbr.length();

        int l = 0;
        int r = 0;

        int num = 0;

        while(l < n && r < m){
            char ch = abbr.charAt(r);
            if(Character.isDigit(ch)){
                if(ch == '0' && num == 0){
                    return false;
                }
                num = num*10 + (ch - '0');
            } else {
                l += num;
                num = 0;
                if(l >= n || word.charAt(l) != ch){
                    return false;
                }
                l++;
            }
            r++;
        }
        return (l+num == n) && (r == m);
    }
}