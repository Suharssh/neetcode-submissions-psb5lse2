class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq_s1 = new int[26];
        int[] freq_s2 = new int[26];
        int l = 0;
        for(int i = 0; i < s1.length(); i++){
            freq_s1[s1.charAt(i) - 'a']++;
        }
        for(int r = 0; r < s2.length(); r++){

            freq_s2[s2.charAt(r) - 'a']++;

            if(r-l+1 > s1.length()){
                freq_s2[s2.charAt(l) - 'a']--;
                l++;
            }

            if(r-l+1 == s1.length()){
                if(Arrays.equals(freq_s1, freq_s2)) return true;
            }
        }
        return false;
    }
}
