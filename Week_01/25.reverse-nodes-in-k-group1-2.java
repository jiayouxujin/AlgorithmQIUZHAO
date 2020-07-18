/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
       if(head==null||head.next==null){
           return head;
       }

       ListNode tail=head;
       for(int i=0;i<k;i++){
           if(tail==null){
               return head;
           }
           tail=tail.next;
       }

       ListNode newHead=reverse(head, tail);
       head.next=reverseKGroup(tail, k);

       return newHead;
    }

    public ListNode reverse(ListNode head,ListNode tail){
       ListNode pre=null;
       ListNode next=null;

       while(head!=tail){
           next=head.next;
           head.next=pre;
           pre=head;
           head=next;
       }

       return pre;
    }
}
// @lc code=end

