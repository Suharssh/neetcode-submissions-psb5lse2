class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charfreq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b - a
        );

        for(int i = 0; i < tasks.length; i++){
            charfreq[tasks[i] - 'A']++;
        }

        for(int i = 0; i < 26; i++){
            if(charfreq[i] > 0){
                pq.add(charfreq[i]);
            }
        }

        int ans = 0;

        while(!pq.isEmpty()){
            int currentcycle = 0;
            int maxcycle = n+1;
            ArrayList<Integer> list = new ArrayList<>();
            while(maxcycle > 0 && !pq.isEmpty()){
                int curr = pq.poll();
                if(curr > 1){
                    list.add(curr - 1);
                }
                currentcycle++;
                maxcycle--;
            }
            for(int l : list){
                pq.add(l);
            }
            ans += pq.isEmpty() ? currentcycle : n+1;
        }
        return ans;
    }
}
