class Solution {
    public ListNode removeNodes(ListNode head) {

        // Step 1: reverse the list
        head = reverse(head);

        // Step 2: keep max so far
        int max = head.val;
        ListNode curr = head;

        while (curr.next != null) {
            if (curr.next.val < max) {
                // delete node
                curr.next = curr.next.next;
            } else {
                // update max
                curr = curr.next;
                max = curr.val;
            }
        }

        // Step 3: reverse again to restore order
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
