/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpy=new ListNode(0);
        ListNode cur=dumpy;

        int sum=0;
        while(l1!=null||l2!=null){
            sum/=10;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            cur.next=new ListNode(sum%10);
            cur=cur.next;
        }
        if(sum/10==1){
            cur.next=new ListNode(1);
        }
        return dumpy.next;
    }
}
// @lc code=end

