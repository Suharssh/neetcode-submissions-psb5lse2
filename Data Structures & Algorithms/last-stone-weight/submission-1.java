class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones) maxHeap.add(stone);

        while(!maxHeap.isEmpty()){
            int x = maxHeap.poll();
            if(!maxHeap.isEmpty()){
                int y = maxHeap.poll();
                int z = x - y;
                if(z!=0) maxHeap.add(z);
            } else {
                return x;
            }
        }
        
        return 0;
    }
}
