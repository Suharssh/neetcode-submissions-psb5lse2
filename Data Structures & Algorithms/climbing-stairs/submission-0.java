class Solution {
    public int climbStairs(int n) {
        int pos=1;
        int fibo=1;
        int cont=1;
        while (n!=cont){
            int temp= fibo;
            fibo=fibo+pos;
            pos=temp;
            cont++;
        }
        return fibo;
    }
}