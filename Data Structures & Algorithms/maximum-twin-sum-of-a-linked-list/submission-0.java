/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        int sum = 0;
        int maxsum = 0;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondhalfstart = slow.next;
        slow.next = null;
        ListNode middle = reverse(secondhalfstart);
        ListNode curr = head;

        while(curr != null && middle != null){
            sum = middle.val + curr.val;
            maxsum = Math.max(maxsum, sum);
            curr = curr.next;
            middle = middle.next;
        }

        return maxsum;
        
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}