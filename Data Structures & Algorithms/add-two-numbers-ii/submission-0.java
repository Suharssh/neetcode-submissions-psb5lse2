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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverse_l1 = reverse(l1);
        ListNode reverse_l2 = reverse(l2);
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(reverse_l1 != null || reverse_l2 != null || carry != 0){
            int x = (reverse_l1 != null) ? reverse_l1.val : 0;
            int y = (reverse_l2 != null) ? reverse_l2.val : 0;

            int sum = x + y + carry;
            carry = sum/10;

            curr.next = new ListNode(sum%10);

            curr = curr.next;
            if(reverse_l1 != null) reverse_l1 = reverse_l1.next;
            if(reverse_l2 != null) reverse_l2 = reverse_l2.next;
        }
        return reverse(dummy.next);
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