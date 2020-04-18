/*
	算法思想：
		双指针
	两块板子盛放水的容量取决于两块板子的min（高）
	面积 = 高*（两者索引之差）
	由于要找面积的最大值，因此用进行板子移动，如果移短板，则S可能会变大；如果移长板，则S可能不变/减小
*/


class Solution {
    public int maxArea(int[] height) {
        //双指针
        int low = 0;
        int high = height.length-1;
        //保存结果
        int res = 0;
        while(low < high){
			//算出当前面积大小
            int s = Math.min(height[low],height[high]) * (high-low);
            res = Math.max(s,res);
			//移动短板
            if(height[low] < height[high])
                low++;
            else
                high--;
        }
        return res;
    }
}












