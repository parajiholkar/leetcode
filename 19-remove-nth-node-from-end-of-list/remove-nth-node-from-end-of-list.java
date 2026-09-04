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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        if(head == null || n == 0) return head;

        ListNode fastnode = dummy;
        ListNode current = dummy;

        for(int i=0; i<=n; i++){
            fastnode = fastnode.next;
        }

        while(fastnode != null){
            current = current.next;
            fastnode = fastnode.next;
        }

        current.next = current.next.next;

        return dummy.next;
    }
}