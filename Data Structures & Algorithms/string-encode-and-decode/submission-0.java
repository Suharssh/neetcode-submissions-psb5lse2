class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for(int i = 0, j = 0; j < str.length();){
            int n = 0;
            while('0' <= str.charAt(j) && str.charAt(j) <= '9'){
                n = n*10 + str.charAt(j) - '0';
                j++;
            }
            i=j+1;
            j+=n+1;
            res.add(str.substring(i,j));
            i=j;
        }
        return res;
    }
}
