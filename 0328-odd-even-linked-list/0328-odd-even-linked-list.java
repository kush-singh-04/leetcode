

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode tempA = odd;
        ListNode tempB = even;
        ListNode temp = head;
        int i = 1;
        while(temp!=null){
            if(i%2 != 0){
                tempA.next=temp;
                temp=temp.next;
                tempA=tempA.next;
                 
            }
            else {
                tempB.next=temp;
                temp=temp.next;
                tempB=tempB.next;
                 
            }
            i++;
        }
        tempB.next=null;
        odd=odd.next;
        even=even.next;
        if(odd==null) return even;
        tempA.next=even;
        return odd;

        
        
    }
}