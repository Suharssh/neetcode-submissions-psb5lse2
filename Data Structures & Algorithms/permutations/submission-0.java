class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 1, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int idx, List<Integer> curr){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            helper(nums, i+1, curr);
            curr.removeLast();
        }
    }
}
