/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummpy.next=head;
        ListNode current=dummy;

        while(current.next!=null&&current.next.next!=null){
            ListNode first=current.next;
            ListNode second=current.next.next;
            first.next=second.next;
            current.next=second;
            second.next=first;
            current=current.next.next;
        }

        return dummy.next;
    }
}
// @lc code=end

