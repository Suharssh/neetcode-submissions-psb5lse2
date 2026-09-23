class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> seenT = new HashMap();
        HashMap<Character, Integer> window = new HashMap();
        for(char c : t.toCharArray())
            seenT.put(c, seenT.getOrDefault(c,0)+1);
        
        int have = 0, need = seenT.size();
        int[] res = {-1,-1};
        int len = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch,0)+1);
            if(seenT.containsKey(ch) && window.get(ch).equals(seenT.get(ch))){
                have++;
            }

            while(have == need){
                if((r-l+1) < len){
                    len = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftchar = s.charAt(l);
                window.put(leftchar, window.get(leftchar) - 1);
                if(seenT.containsKey(leftchar) && window.get(leftchar) < seenT.get(leftchar)){
                    have--;
                }
                l++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
