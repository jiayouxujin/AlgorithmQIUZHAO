/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
//[1,2]
// 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead=new ListNode(0);
        newHead.next=head;
        ListNode slow=newHead,fast=newHead;
        while(n>0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return newHead.next;
    }
}
// @lc code=end

