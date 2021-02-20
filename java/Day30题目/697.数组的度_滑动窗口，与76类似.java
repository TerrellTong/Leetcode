/*
	算法思想：
		滑动窗口，但是我的思路是不能解决重复元素的！！！
		对于重复元素的处理，我们再次设置一个Map，用于存储，每次都是判断存储时的最右边界的次数，如果满足度数，则窗口缩小，
		通过这个操作，我们可以解决重复的元素 [1, 2, 2, 3, 1]
		感觉与76的思想类似
*/


class Solution {
    public int findShortestSubArray(int[] nums) {
        //找到nums数组的度
        Map<Integer,Integer> count_Map = new HashMap();
        for(int num : nums)
            count_Map.put(num,count_Map.getOrDefault(num,0)+1);
        //degree存放入度，value存放哪个值的频次是入度
        int maxDegree = count_Map.get(nums[0]);
        for(int key : count_Map.keySet()){
            if(count_Map.get(key) >= maxDegree){
                maxDegree = count_Map.get(key);
            }
        }
        //最短的连续子数组
        int count = 0;
        int left = 0;
        int right = 0;
        int minSize = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        while(right < nums.length){
            //窗口扩大,不能用单独的一个int存储，因为存在重复元素，因此可以采用map存储
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            //窗口收缩,当此时窗口的右边界的值的次数==maxDegree 就要收缩了
            while(map.get(nums[right]) == maxDegree){
                //移除左窗口
                map.put(nums[left],map.get(nums[left])-1);
                minSize = Math.min(minSize,right-left+1);
                left++;
            }
            right++;
        }
        return minSize;
    }
}