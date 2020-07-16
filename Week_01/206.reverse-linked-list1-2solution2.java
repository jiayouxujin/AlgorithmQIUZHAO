/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        return reverseListNode(head,null);
    }

    public ListNode reverseListNode(ListNode head,ListNode newHead){
        if(head==null){
            return newHead;
        }

        ListNode next=head.next;
        head.next=newHead;
        return reverseListNode(next,head);
    }
}
// @lc code=end

