/*
	算法思想：
		多次翻转，首先整个数组进行翻转，然后从0开始到取余的位置进行翻转，最后对取余后的位置进行翻转
		二刷，之前是用链式反应，不会做！！！
		
		
题解：https://leetcode-cn.com/problems/rotate-array/solution/javadai-ma-3chong-fang-shi-tu-wen-xiang-q8lz9/ ，方法二
*/



class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        //取余后，判断要移动多少个位置
        k = k%len;
        reverse(nums,0,len-1);//先翻转全部元素
        reverse(nums,0,0+k-1);//然后翻转前k个元素
        reverse(nums,k,len-1);//最后翻转剩余的
    }

    public void reverse(int[] nums,int start ,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}