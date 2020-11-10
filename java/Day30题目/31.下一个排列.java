/*
	算法思想：
		从后向前找到一个较小值，然后再找一个较大值，较大值和较小值进行互换，较大数右边重新升序排列，这样可以让变化幅度减小
		相当于二刷，知道要从后向前遍历，后面的步骤不会做了，但是没有理解为什么要这么做！！
		
题解：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/

*/

class Solution {
    //我们将一个左边的较小数与右边的较大数进行交换，这样我们就可以得到下一个排列
    //而且我们要让这个较小数尽量靠右，而且较大数尽可能的小。交换完成后，较大数右边需要重新升序排列，这样可以让变化幅度减小
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        //此时找到一个较小数，因为a[i] < a[i+1]
        while(i >= 0 &&nums[i] >= nums[i+1])
            i--;

        //如果i为非0，则一定可以找到下一个升序排列
        if(i >= 0){
            int j = nums.length-1;
            //开始找较大数（可以取等于）
            while(j >= i && nums[j] <= nums[i])
                j--;
            //此时较大数和较小数都找到了，则进行交换
            swap(nums,i,j);
        }
        //较大数右边重新升序排列，这样可以让变化幅度减小
        //此时的较大数已经是i了！
        reverse(nums,i+1);
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums,int idex){
        int end = nums.length-1;
        while(idex < end){
            swap(nums,idex,end);
            idex++;
            end--;
        }
    }
}