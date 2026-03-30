class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> Smap = new HashMap<>();
        HashMap<Character, Integer> Hmap = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            Smap.put(s.charAt(i), Smap.getOrDefault(s.charAt(i),0)+1);
            Hmap.put(t.charAt(i), Hmap.getOrDefault(t.charAt(i),0)+1);
        }
        for(Character c : Smap.keySet()){
            if(!Smap.get(c).equals(Hmap.get(c))) return false;
        }
        return true;
    }
}
