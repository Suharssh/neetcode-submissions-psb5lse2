class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int m = l + (r-l)/2;
            // left neighbor
            // if the ele is smaller than left, then peak is to the left.
            if(m > 0 && nums[m] < nums[m-1]) r = m - 1;

            // right neighbor
            // if the ele is larger than right, then peak is to the right.
            else if(m < nums.length - 1 && nums[m] < nums[m+1]) l = m + 1;
            else return m;

            // dont need to reduce the search space by half, just move the ptrs.
        }
        return l;
    }
}