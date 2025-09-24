 
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        ListNode nxt=head; // both we can intalise form head and null
        while(current!=null){
            nxt = current.next;
            current.next=pre;
            pre=current;
            current=nxt;
        }
        return pre;
        
    }
}