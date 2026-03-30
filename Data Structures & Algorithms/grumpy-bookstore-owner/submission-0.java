class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int l = 0;
        int satisfied = 0;
        int max = 0, window = 0;
        for(int r = 0; r < customers.length; r++){
            if(grumpy[r] == 1){
                window += customers[r];
            } else {
                satisfied += customers[r];
            }
            if(r-l+1 > minutes){
                if(grumpy[l] == 1){
                    window -= customers[l];
                }
                l++;
            }
            max = Math.max(window, max);
        }
        return satisfied + max;
    }
}