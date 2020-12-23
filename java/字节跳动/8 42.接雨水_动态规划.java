/*
	算法思想：
		动态规划
		找出当前墙面，左墙和右墙中较小的一个
		如果当前列小于它们中较小的，才会有水！
		
题解：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/ 解法三
*/

class Solution {
    public int trap(int[] height) {
        int sum = 0;
        //记录当前墙面的左边最大值
        int[] max_left = new int[height.length];
        //记录当前墙面的右边最大值
        int[] max_right = new int[height.length];
        for(int i=1;i<height.length;i++){
            //当前列的最大值，是当前墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
            max_left[i] = Math.max(max_left[i-1],height[i-1]);
        }
        for(int i=height.length-2;i>=0;i--){
            //同上
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }
        for(int i=0;i<height.length;i++){
			//找出两端较小的
            int min = Math.min(max_left[i],max_right[i]);
			//只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if(min > height[i])
                sum += min-height[i];
        }
        return sum;
    }
}