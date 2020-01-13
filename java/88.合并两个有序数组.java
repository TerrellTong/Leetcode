/*
	思想：
		双指针（三指针） 一个指针在nums1的尾部，一个在nums1的m处，还一个在nums2的n处
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            //如果数组1的数值小于数组2的数值，那么就把数组2的值放到p指针，然后数组2的指针左移一位，反之
            // 注意--符号在后面，表示先进行计算再减
             nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
		//从nums2中添加被忽略的元素（即nums1中没有元素，nums2中存在元素）
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        //如果长度为len2，那么当len2元素全部赋好值了，那么len2会变为-1，再执行操作就会报错
        System.arraycopy(nums2, 0, nums1, 0, len2+1);
    }
}






