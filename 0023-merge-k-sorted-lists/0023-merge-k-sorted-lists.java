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
    public ListNode mergeKLists(ListNode[] lists) {
        // Min Heap based on node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Step 1: Add all heads
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // Dummy node
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // Step 2: Process heap
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            // Push next node
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}