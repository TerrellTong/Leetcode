/*
	算法思想：
		将数组视为哈希表
		数值为 i 的数映射到下标为 i - 1 的位置。如果不满足则交换
		
题解：https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            //nums[nums[i]-1] != nums[i] ，表示当前数字并没有呆在相应的位置上
            while(nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]){
                //交换
                //例如数值3应该放到索引2的位置上，可以自己代入，然后判断是否满足这个公式
                swap(nums,nums[i]-1,i);
            }
        }

        for(int i=0;i<len;i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return len+1;
    }

    public void swap(int[] nums,int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}