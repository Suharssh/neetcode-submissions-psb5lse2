class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> maps = new HashMap<>();
        HashMap<Character, Character> mapt = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if((maps.containsKey(c1) && maps.get(c1) != c2) || (mapt.containsKey(c2) && mapt.get(c2) != c1)) return false;
            maps.put(c1,c2);
            mapt.put(c2,c1);
        }
        return true;
    }
}