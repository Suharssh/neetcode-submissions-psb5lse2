class Solution {
    public int maxDifference(String s) {
        int maxodd = 0;
        int mineven = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(i) == (s.charAt(j))){
                    count++;
                }
            }
            if(count%2==1) maxodd = Math.max(maxodd,count);
            else mineven = Math.min(mineven, count);
        }
        return maxodd-mineven;
    }
}