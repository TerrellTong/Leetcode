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



https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/er-fen-jian-zhi-si-xiang-fen-zhi-si-xiang-by-liwei/

public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]) {
                // [3, 4, 5, 1, 2]，mid 以及 mid 的左边一定不是最小数字
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                // 只能把 right 排除掉，下一轮搜索区间是 [left, right - 1]
                right = right - 1;
            } else {
                // 此时 numbers[mid] < numbers[right]
                // mid 的右边一定不是最小数字，mid 有可能是，下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }

        // 最小数字一定在数组中，因此不用后处理
        return numbers[left];
    }

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/er-fen-jian-zhi-si-xiang-fen-zhi-si-xiang-by-liwei/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。