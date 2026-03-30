class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        char[] c = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            score+=Math.abs(c[i-1] - c[i]);
        }
        return score;
    }
}