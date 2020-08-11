import java.util.List;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (40.21%)
 * Likes:    5016
 * Dislikes: 296
 * Total Accepted:    672.3K
 * Total Submissions: 1.7M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;   
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list2 != null)
            curr.next = list2;
        else
            curr.next = list1;
        return dummy.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        int len = lists.length;
        while( len != 1 ){
            for(int i = 0; i < len/2; i++)
                lists[i] = mergeTwoLists(lists[2*i], lists[2*i+1]);
            if (len % 2 == 1)
                lists[len/2] = lists[len-1];
            len = (len+1)/2;        // current length
        }

        return lists[0];
       
    }
}
// @lc code=end

