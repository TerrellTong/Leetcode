/*
	算法思想：
		二分查找！
「使……最大值尽可能小」是二分搜索题目常见的问法。
此题是直接从最大值的最小值区间找数，然后以区间的值为基础进行数组划分， 不是对显性数组进行二分操作
思路：
	假设这个中点mid就是 “每一个数组和的最大值” 的最小值
	那么每一个数组和必定<=mid
	你用这个值来对数组进行从头分割，一旦当前数组和>mid,就结束该数组，开启一个新数组
	如果你用这个mid创建的数组数量，比m还多，说明你这个值定小了，所以二分查找取哪一半？右半！
	如果你用这个mid创建的数组数量，比m少了，说明你这个值定大了，所以二分查找取哪一半？左半！

作者：xiao-yan-gou
链接：https://leetcode-cn.com/problems/split-array-largest-sum/solution/bai-hua-er-fen-cha-zhao-by-xiao-yan-gou/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

https://leetcode-cn.com/problems/split-array-largest-sum/solution/bai-hua-er-fen-cha-zhao-by-xiao-yan-gou/
https://leetcode-cn.com/problems/split-array-largest-sum/solution/er-fen-cha-zhao-by-coder233-2/
*/

class Solution {
    public int splitArray(int[] nums, int m) {
        int left = nums[0];
        int right = 0;
        //最大值的最小值的范围[max(nums),sum(nums)]]
        for(int num:nums){
            left = Math.max(left,num);
            right += num;
        }
        //开始进行二分查找
        while(left <= right){
            //由于最大值的最小值的范围已经确定了，我们采用二分查找
            int mid = (left+right) >>> 1;
            int temp = 0,count =1;
            for(int num:nums){
                temp += num;
                //判断前几个数组和是否大于mid，如果大于mid，则重新开始一个新数组(相当于又划分了一次)
                if(temp > mid){
                    temp = num;
                    count++;
                }
            }
            //如果count大于给定的m次数，那么说明mid确定小了，准确的范围在右区间
            if(count > m)
                left = mid+1;
            else //否则说明划分的子数组少了，即mid偏大（或者刚好处于目标值），但是我们可以继续right = mid-1,因为最后的返回值left永远都是mid+1，可以弥补我们的过错
                right = mid-1;
			//如果count==m,不能返回，因为无法确定此时的mid是最小值，它只满足了每一个数组和必定<=mid
			//当我们的查找范围只有一个数的时候就可以返回了
        }
        return left;
    }
}