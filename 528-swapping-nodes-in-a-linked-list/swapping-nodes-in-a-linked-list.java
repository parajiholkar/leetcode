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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode kthNode;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i=0; i<k; i++){
            fast = fast.next;
        }

        kthNode = fast;

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        int temp = kthNode.val;
        kthNode.val = slow.val;
        slow.val = temp;

        return dummy.next;
    }
}