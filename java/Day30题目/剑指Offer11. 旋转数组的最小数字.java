/*
	算法思想：
		二分查找
	当numbers[m]> numbersLjl时: m一定在左排序数组中，即旋转点α一定在[m+1,j闭区间内，因
		此执行i= m＋1;
	当numbers[m]< numberslj]时: m一定在右排序数组中，即旋转点α一定在[i, m]闭区间内，因此执
		行j= m;
	当numbers[m]=- numbers[j]时:无法判断m在哪个排序数组中，即无法判断旋转点z在[i, m]还是
		[m+1,j]区间中。解决方案:执行j=j一1缩小判断范围(分析见以下内容)。

		
https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/	
*/

class Solution {
    //找到旋转点的值，不是找索引
    public int minArray(int[] numbers) {
        int i=0,j=numbers.length-1;
        while(i<j){
            int m = (i+j) >>> 1;
            //说明m在左排序数组中，旋转点一定在[m+1,j]中
            if(numbers[m] > numbers[j]) 
                i = m+1;
            //说明m在右排序数组中，旋转点一定在[i,m]中
            else if(numbers[m] < numbers[j])
                j = m; //不能取j=m-1,因为m有可能就是旋转点
            else
                j = j-1;
        }
        return numbers[i];
    }
}