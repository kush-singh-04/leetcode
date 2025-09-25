
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode j = reverseList(slow);
        ListNode i = head;
        while(j!=null){
            if(i.val!=j.val)return false;
            i=i.next;
            j=j.next;
        }
        return true;
    }
}