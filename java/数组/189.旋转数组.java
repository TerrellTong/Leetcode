/*
	算法思想：
		链式反应，当我们存储的中间值时，我们将next_index赋值为index，这样我们就可以一直交换，交换次数为nums的长度！
	

题解：https://leetcode-cn.com/problems/rotate-array/solution/javashi-xian-zhi-jie-jiao-huan-kong-jian-fu-za-du-/
*/

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        //判断要移动的是不是nums.length的倍数，如果是的话就不需要进行操作
        if(k == 0 || nums.length == 1)
            return;
        
        //交换位置，交换的次数为数组的长度
        int index = 0;
        //记录当前索引的值
        int cache = nums[index];
        int start = 0;
        for(int i=0;i<nums.length;i++){
            int next_index = (index + k) % nums.length;
            //交换
            int tmp = nums[next_index];
            nums[next_index] = cache;
            cache = tmp;
            //将next_index 赋值给 index
            index = next_index;
            //如果nums的长度是偶数，则会出现环，这样就要index++
            if(index == start){
                index++;
                start = index;
                cache = nums[index];
            }
        }
        
    }
}
