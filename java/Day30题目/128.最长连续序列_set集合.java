/*
	算法思想：
		set集合
	set集合的特点： A:存入集合的顺序和取出集合的顺序不一致
					B:没有索引
					C:存入集合的元素没有重复
	
*/
 
class Solution {
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        Set<Integer> set_nums = new HashSet();
        //将nums数组的元素全部插入到set中
        for(int i=0;i<nums.length;i++){
            set_nums.add(nums[i]);
        }
        //对set进行遍历
        for(int num:set_nums){
            //如果set集合中不包含num-1，因为如果set_nums集合包含了num-1,说明这个值在之前的currentnum+1已经进行了计算，
			//以免重复计算
            if(!set_nums.contains(num-1)){            
                int currentnum = num;
                int currentStreak = 1;
                //如果set_nums集合包含currentnum+1，则继续添加
                while(set_nums.contains(currentnum+1)){
                    currentStreak += 1;
                    currentnum += 1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}









