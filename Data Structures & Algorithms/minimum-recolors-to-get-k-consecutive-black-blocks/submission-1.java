class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int cnt = 0;
        int mincnt = Integer.MAX_VALUE;
        for(int r = 0; r < blocks.length(); r++){
            if(r - l + 1 > k){
                
                if(blocks.charAt(l) == 'W'){
                    cnt--;
                } 
                l++;
            }
            if(blocks.charAt(r) == 'W'){
                cnt++;
            }
            if(r-l+1 == k) mincnt = Math.min(cnt,mincnt);
        }
        return mincnt;
    }
}