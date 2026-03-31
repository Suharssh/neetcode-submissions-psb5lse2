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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondhalfstart = slow.next;
        slow.next = null;
        ListNode middle = reverse(secondhalfstart);

        ListNode curr = head;
        while(middle != null){
            ListNode nxt = curr.next;
            ListNode reversenxt = middle.next;
            curr.next = middle;
            middle.next = nxt;
            curr = nxt;
            middle = reversenxt;
        }
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
