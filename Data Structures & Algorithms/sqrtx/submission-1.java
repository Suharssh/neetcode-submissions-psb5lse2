class Solution {
    public int mySqrt(int x) {
        long l = 1;
        long r = (long)x;
        while(l <= r){
            long m = (l+r)/2;
            if(m*m > x) r = m - 1;
            else if(m*m < x) l = m + 1;
            else return (int)m;
        }
        return (int) l - 1;
    }
}