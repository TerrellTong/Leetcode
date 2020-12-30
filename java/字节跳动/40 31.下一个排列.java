/*
	算法思想：
		之前做过，还是忘了！！！
		为了找到一个较小数，尽量靠右，因此我们从右往前找，找到第一个nums[i] < nums[i+1] 的值，然后以此为基础，找到一个大于它的较大的值，交换后，翻转即可！
*/


class Solution {
    public void nextPermutation(int[] nums) {
        int left = 0;
        int i = nums.length-2;
        //同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
        //从右边往左边找，找到一个当前元素 < 后面的元素（存在下一个更大的排列，这就是一个较小数）:
        /*  1)找到大于当前元素的最后一个元素，记录下标
            2)交换选中的两个数组元素
            3)转置后面的元素
        */
        //反之，不存在下一个更大的排列
        while(i >= 0){
            if(nums[i] >= nums[i+1])
                i--;
            else
                break;
        }
        //此时i为较小数的位置

        //i>=0，说明存在
        if(i >= 0){
            int j = nums.length-1;
            //找到一个较大数
            while(j > i && nums[j] <= nums[i])
                j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums,int index){
        int start = index;
        int end = nums.length-1;
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}