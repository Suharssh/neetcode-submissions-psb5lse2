class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n,k,1,new ArrayList<>());
        return res;
    }
    private void helper(int n, int k, int idx, List<Integer> curr){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx > n){
            return;
        }
        for(int i = idx; i <= n; i++){
            curr.add(i);
            helper(n,k,i+1,curr);
            curr.removeLast();
        }
    }
}