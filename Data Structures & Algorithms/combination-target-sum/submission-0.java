class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums, target, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int target, int i, List<Integer> curr){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i >= nums.length || target < 0) return;
        curr.add(nums[i]);
        helper(nums, target - nums[i], i, curr);
        curr.removeLast();
        helper(nums, target, i + 1, curr);
    }
}
