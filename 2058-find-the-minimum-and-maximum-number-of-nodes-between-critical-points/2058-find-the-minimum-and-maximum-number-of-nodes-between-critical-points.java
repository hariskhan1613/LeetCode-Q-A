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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prev = -1;
        int min = Integer.MAX_VALUE;

        ListNode curr = head.next;
        ListNode prevNode = head;
        int index = 1;

        while (curr.next != null) {
            if ((curr.val > prevNode.val && curr.val > curr.next.val) ||
                (curr.val < prevNode.val && curr.val < curr.next.val)) {

                if (first == -1) {
                    first = index;
                } else {
                    min = Math.min(min, index - prev);
                }

                prev = index;
            }

            prevNode = curr;
            curr = curr.next;
            index++;
        }

        if (first == -1 || prev == first) {
            return new int[]{-1, -1};
        }

        return new int[]{min, prev - first};
    }
}