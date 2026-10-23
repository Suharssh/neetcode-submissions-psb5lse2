/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start - b.start);
        PriorityQueue<Integer> minrooms = new PriorityQueue<>();
        for(Interval i : intervals){
            if(!minrooms.isEmpty() && minrooms.peek() <= i.start){
                minrooms.poll();
            }
            minrooms.offer(i.end);
        }
        return minrooms.size();
    }
}
