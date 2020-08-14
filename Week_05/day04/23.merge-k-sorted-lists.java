/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.size()==0) return null;
        return helper(lists,0,lists.size()-1);
    }

    public ListNode helper(ListNode[] lists,int lo,int hi){
        if(lo>=hi) return lists[lo];

        int mid=lo+(hi-lo)/2;
        ListNode left=helper(lists,lo,mid);
        ListNode right=helper(lists,mid+1,hi);

        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right){
        if(left==null) return right;
        if(right==null) return left;

        if(left.val<right.val){
            left.next=merge(left.next,right);
            return left;
        }else{
            right.next=merge(left,right.next);
            return right;
        }
    }
}
// @lc code=end

