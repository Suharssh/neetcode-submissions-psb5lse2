class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[1001];
        Stack<Integer> mono = new Stack<>();
        for(int i = nums2.length - 1; i >= 0; i--){
            while(!mono.isEmpty() && mono.peek() <= nums2[i]){
                mono.pop();
            }
            res[nums2[i]] = mono.isEmpty() ? -1 : mono.peek();
            mono.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = res[nums1[i]];
        }
        return nums1;
    }
}