/*
	算法思想：
		滑动窗口！！
		我考虑的是dp的思想！！（自己太菜了）与LC3题类似！！！
		我只考虑到了用set存储多余的元素，不知道在dp中如何将多余元素处理！！考虑方向：滑动窗口！！！！
		滑动窗口做少了！！
		
	https://leetcode-cn.com/problems/maximum-erasure-value/submissions/
	
题解思想：https://leetcode-cn.com/problems/maximum-erasure-value/solution/hua-dong-chuang-kou-shuang-bai-by-nian-z-8gfv/
*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet();
        int sum = 0;
        //记录滑动窗口的起始位置
        int start = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                sum += nums[i];
                res = Math.max(sum,res);
                set.add(nums[i]);
            }else{
                //当前位置的元素，之前包含了
                //如果当前位置的元素不是包含的，则移除并sum-，而且还要将该元素从set(滑动窗口中移除！)
                //如果是要移除的，由于之前加了，我们可以直接将其从窗口移除，只需要将start++即可！！
                while(nums[i] != nums[start]){
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                //此时的start还是位于nums[i] == nums[start]，我们要将start++,将这个元素移除
                start++;
            }
        }
        return res;
    }
}