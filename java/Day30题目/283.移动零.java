/*
	算法思想：
		之前做过，一次就做了出来
		双指针
	
*/

class Solution {
    public void moveZeroes(int[] nums) {
        //p表示0所在的位置
        int p = 0;
        int index = 0;
        while(index < nums.length){
            if(nums[index] != 0){
                //与p交换
                swap(nums,p,index);
                p++;
                index++;
            }else{
                //此时说明该值为0，需要互换
                index++;
            }
        }
    }

    public void swap(int[] nums,int p,int index){
        int tmp = nums[p];
        nums[p] = nums[index];
        nums[index] = tmp;
    }
}