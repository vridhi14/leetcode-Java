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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null)return head ; 

        ListNode mid = getMid(head);
        ListNode left = head ; 
        ListNode right = mid.next ;
        mid.next = null ; 

        left = sortList(left);
        right = sortList(right);

        return merge(left , right);
    }

    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next ; 
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode a , ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(a!=null && b!=null){
            if(a.val<=b.val){
                temp.next=a;
                a=a.next;
            }
            else{
                temp.next=b;
                b=b.next;
            }
            temp = temp.next;
        }

        if(a!=null) temp.next=a;
        if(b!=null) temp.next=b;
        
        return dummy.next;
    }

}