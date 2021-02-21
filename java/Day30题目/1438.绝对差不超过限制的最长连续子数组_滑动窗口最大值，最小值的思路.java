/*
	算法思想：
		滑动窗口，思路知道但是不知道最大值最小值的求法，最大值最小值采用特殊的数据结构TreeMap解决即可！！！
		本题的重点在于快速求滑动窗口内的最大值和最小值。常见的方法有：
			使用 multiset、TreeMap等数据结构；
			单调递增队列或者单调递减队列；
题解：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/he-gua-de-shu-ju-jie-gou-hua-dong-chuang-v46j/
*/


class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //通过TreeMap来存储最大值和最小值,相当于PriorityQueue，默认按照key的字典顺序进行升序排序
        TreeMap<Integer,Integer> map = new TreeMap();
        int left = 0, right = 0;
        int maxsize = Integer.MIN_VALUE;
        while(right < nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            right++;
            //如果窗口的最大值-最小值>limit，则进行窗口收缩
            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            //我们要的是绝对植差小于/等于limit的值，因此不能写在窗口收缩的语句中
            maxsize = Math.max(maxsize,right-left);
        }
        return maxsize;
    }
}