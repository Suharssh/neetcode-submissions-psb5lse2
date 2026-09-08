class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int leftmax = height[l], rightmax = height[r];
        int res = 0;
        while(l < r){
            if(leftmax < rightmax){
                l++;
                leftmax = Math.max(leftmax, height[l]);
                res += leftmax - height[l];
            } else {
                r--;
                rightmax = Math.max(rightmax, height[r]);
                res += rightmax - height[r];
            }
        }
        return res;
    }
}
