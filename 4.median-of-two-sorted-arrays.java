/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (29.57%)
 * Likes:    7486
 * Dislikes: 1180
 * Total Accepted:    713.6K
 * Total Submissions: 2.4M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {  
        int m= nums1.length, n = nums2.length; 
        int i = 0, j = 0;
        int i_min = 0, i_max = m, maxLeft = 0, minRight = 0; 
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
            // need to search i in [0, m], ensures j >= 0
        
        while (i_min <= i_max){
            i = (i_min + i_max) / 2;
            j = (m + n + 1)/2 - i;
            if (i > 0 && j < n && nums1[i-1] > nums2[j]){
                i_max = i - 1;
            }
            else if (i < m && j > 0 && nums1[i] < nums2[j-1]){
                i_min = i + 1;    
            }
            else{
                if (i == 0)
                    maxLeft = nums2[j-1];
                else if (j == 0)
                    maxLeft = nums1[i-1];
                else                 
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                break;
            }
        }
        if ((m + n) % 2 == 1)
            return maxLeft;
        
        if(j == n)
            minRight = nums1[i];            
        else if(i == m)
            minRight = nums2[j];
        else 
            minRight = Math.min(nums1[i], nums2[j]);
        
        return (double)(maxLeft + minRight) / 2;
        
    }
}
// @lc code=end

