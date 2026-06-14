class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] candidates, int target, int i, List<Integer> curr){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        int prev = -1;
        for(int idx = i; idx < candidates.length; idx++){
            if(candidates[idx] > target) break;
            if(candidates[idx] == prev) continue;
            curr.add(candidates[idx]);
            helper(candidates, target - candidates[idx], idx + 1, curr);
            curr.removeLast();
            prev = candidates[idx];
        }
    }
}
