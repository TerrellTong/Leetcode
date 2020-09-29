/*
	算法思想：
		一遍扫描
		例如：1，5，8，4，7，6，5，3，1
		如果想找到下一个排列，肯定要从后开始遍历，找到一个不是nums[i] > num[i+1]
		这时，我们将这个位置和后面比它大的互换，然后将后面的序列进行翻转即可！！
	
https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/	
*/


class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后往前，如果是递增的就一直加，知道遇到，num[i] < num[i+1]
        //i是指向的队尾
        while(i >= 0 && nums[i] >= nums[i+1])
            i--;
        
        if(i >= 0){
            int j = nums.length - 1;
            //从队尾开始找到一个刚好大于nums[i]的值即可
            while(j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums,i,j);
        }
        //然后将其翻转
        reverse(nums,i+1);
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums,int start){
        int i = start, j = nums.length - 1;
        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}