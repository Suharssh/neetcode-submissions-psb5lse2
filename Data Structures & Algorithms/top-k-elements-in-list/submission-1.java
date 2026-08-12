class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue(
            (a,b) -> map.get(a) - map.get(b)
        );
        int[] res = new int[k];
        for(int key : map.keySet()){
            pq.add(key);
            if(pq.size() > k) pq.poll();
        }

        for(int i = k-1; i >= 0; i--){
            res[i] = pq.poll();
        }

        return res;
    }
}
