class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1 && trust.length == 0) return 1;
        int[] cnt = new int[n+1];
        for(int[] person : trust){
            cnt[person[0]]--;
            cnt[person[1]]++;
        }
        for(int p = 0; p < cnt.length; p++){
            if(cnt[p] == n-1) return p;
        }
        return -1;
    }
}