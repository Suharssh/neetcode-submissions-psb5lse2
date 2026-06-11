class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.<int[]>comparingInt(a -> a[1]).thenComparingInt(a -> a[0]));
        for(int i = 0; i < nums.length; i++){
            minHeap.offer(new int[] {i,nums[i]});
        }
        for(int i = 0; i < k; i++){
            int[] num = minHeap.poll();
            int mult = num[1]*multiplier;
            minHeap.offer(new int[] {num[0], mult});
        }
        for(int i = 0; i < nums.length; i++){
            int[] num = minHeap.poll();
            nums[num[0]] = num[1];
        }
        return nums;
    }
}