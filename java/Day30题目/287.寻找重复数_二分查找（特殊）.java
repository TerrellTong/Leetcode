/*
	算法思想：
		二分查找，比较特殊
		此题给了一个思路：二分法还可以用于确定一个有范围的整数
		抽屉原理：桌上有十个苹果，要把这十个苹果放到九个抽屉里，无论怎样放，我们会发现至少会有一个抽屉里面放不少于两个苹果。
	
	由于题目要求给了我们查找的数是一个整数，并且给出了这个整数的范围（在 1 和 n 之间，包括 1 和 n），并且给出了一些限制，
	于是可以使用二分查找法定位在一个区间里的整数；
	
	以 [2, 4, 5, 2, 3, 1, 6, 7] 为例，一共 8 个数，n + 1 = 8，n = 7，根据题目意思，每个数都在 1 和 7 之间。

	例如：区间 [1, 7] 的中位数是 4，遍历整个数组，统计小于等于 4 的整数的个数，最多为 4 个，等于 4 的时候也可能有重复。
		但是，如果整个数组里小于等于 4 的整数的个数严格大于 4 的时候，就可以说明重复的数存在于区间 [1, 4]。


作者：liweiwei1419
链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
 
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while(left < right){
            int mid= (left+right)>>>1;

            //用于计数
            int cnt = 0;
            for(int num : nums){
                if(num <= mid)
                    cnt += 1;
            }

            //根据抽屉提原理，小于等于mid的个数如果大于mid
            //重复元素一定在[left, mid]区间
            if(cnt > mid){
                //重复元素在mid左边，不能进行right = mid-1,因为有可能mid就是重复的那个元素
                right = mid;
            }else{
                //就在mid的反面;
                left = mid+1;
            }
        }
        return left;   
    }
}











