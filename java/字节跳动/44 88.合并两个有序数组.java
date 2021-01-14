/*
	算法思想：
		从后面开始考虑，之前做过，还是不会！
		在与nums2交换的时候，会把0与nums2的元素进行交换！！！
		尾部大的一方，放到nums1的尾部！！
	
	题解思想：https://leetcode-cn.com/problems/merge-sorted-array/solution/88-by-ikaruga/
*/



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int end = m+n-1;
        //从后面开始考虑
        while(p2 >= 0){
            while(p1 >= 0 && nums1[p1] > nums2[p2]){
                int t = nums1[p1];
                nums1[p1] = nums1[end];
                nums1[end] = t;
                end--;
                p1--;
            }

            int t = nums2[p2];
                nums2[p2] = nums1[end];
                nums1[end] = t;
                end--;
                p2--;
        }
    }
}