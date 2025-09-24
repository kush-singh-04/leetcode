 
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode tempA=dummy;
        while(tempA.next!=null && tempA.next.next!=null){
            ListNode first=tempA.next;
            ListNode second=tempA.next.next;

            first.next = second.next;
            second.next = first;
            tempA.next = second;

            tempA=first;
        }
        return dummy.next;
         

    }
}