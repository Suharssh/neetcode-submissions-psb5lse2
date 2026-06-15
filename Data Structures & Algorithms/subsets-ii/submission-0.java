class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int i, List<Integer> curr){
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(nums, i+1, curr);
        curr.removeLast();
        while(i+1 < nums.length && nums[i] == nums[i+1]) i+=1;
        helper(nums, i+1,curr);
    }
}
