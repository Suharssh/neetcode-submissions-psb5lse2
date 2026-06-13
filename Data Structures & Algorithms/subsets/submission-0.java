class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public void helper(int[] nums, int idx, List<Integer> sublist, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[idx]);
        helper(nums, idx+1, sublist, res);
        sublist.remove(sublist.size() - 1);
        helper(nums, idx+1, sublist, res);
    }
}
