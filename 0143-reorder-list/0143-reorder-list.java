

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        ListNode nxt=head;  
        while(current!=null){
            nxt = current.next;
            current.next=pre;
            pre=current;
            current=nxt;
        }
        return pre;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }
    public void reorderList(ListNode head) {
        ListNode leftmiddle = middleNode(head);
        ListNode head2 = leftmiddle.next;
        leftmiddle.next=null;

        head2 = reverseList(head2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head!=null && head2!=null){
            temp.next=head;
            head=head.next;
            temp=temp.next;

            temp.next=head2;
            head2=head2.next;
            temp=temp.next;

        }
        if(head==null) temp.next=head2;
        if(head2==null) temp.next=head;
        head=dummy.next;

    }
}