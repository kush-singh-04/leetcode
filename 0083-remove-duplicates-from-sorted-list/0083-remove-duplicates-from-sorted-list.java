 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        while(b!=null){
            if(b.val==a.val) b=b.next;
            else if(b.val!=a.val){
                a.next=b;
                a=b;
                b=b.next;
            }
            a.next=null;
             
             
        
        }
        return head;
             
         
        
    }
}