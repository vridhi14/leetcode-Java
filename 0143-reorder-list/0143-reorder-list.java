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
    public void reorderList(ListNode head) {
            ListNode slow = head;
            ListNode fast = head; 

            while(fast != null && fast.next != null){
                slow = slow.next ; 
                fast = fast.next.next ; 
            }

            ListNode secound = slow.next ; 
            slow.next = null ; 

            ListNode prev = null ; 
            while(secound != null){
                ListNode next = secound.next ; 
                secound.next = prev ; 
                prev = secound ; 
                secound = next ; 
            }
            secound = prev ;

            ListNode first = head;

            while(secound != null){
                ListNode firstNext = first.next ; 
                ListNode secoundNext = secound.next ; 

                first.next = secound ; 
                secound.next = firstNext ; 

                first = firstNext;
                secound = secoundNext;
            }
 
    }
}