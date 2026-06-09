class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long res = 0;
        for(int gift : gifts){
            maxHeap.add(gift);
        }
        while(k>0){
            int val = maxHeap.poll();
            maxHeap.offer((int)Math.sqrt(val));
            k--;
        }
        while(!maxHeap.isEmpty()){
            res += maxHeap.poll();
        }
        return res;
    }
}