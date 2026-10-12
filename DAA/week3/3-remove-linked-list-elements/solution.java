class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip matching node
                current.next = current.next.next;
            } else {
                // Advance pointer
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}
