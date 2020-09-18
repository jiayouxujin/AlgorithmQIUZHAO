/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head,pre=null,fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            pre=slow;
            slow=slow.next;
        }
        pre.next=null;

        ListNode left=sortList(head);
        ListNode right=sortList(slow);

        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode l=new ListNode(0);
        ListNode p=l;

        while(left!=null&&right!=null){
            if(left.val<=right.val){
                p.next=left;
                left=left.next;
            }else{
                p.next=right;
                right=right.next;
            }
            p=p.next;
        }
        if(left!=null){
            p.next=left;
        }
        if(right!=null){
            p.next=right;
        }
        return l.next;
    }
}
// @lc code=end

