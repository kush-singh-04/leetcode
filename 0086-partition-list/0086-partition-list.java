 
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode a = new ListNode(-1);
        ListNode b= new ListNode(-1);
        
        ListNode tempA=a;
        ListNode tempB=b;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                tempA.next=temp;
                temp=temp.next;
                tempA=tempA.next;

            }
            else{ // temp.val>=x
                tempB.next=temp;
                temp=temp.next;
                tempB=tempB.next;
            }
            
        }
        tempB.next=null;// last node
        a=a.next;
        b=b.next;
        if(a==null) return b;// very important
        tempA.next=b;// list a attached to list b
        return a;
         
         
        
        
        
        
        
        
    }

}