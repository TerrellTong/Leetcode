 /*
	算法思想：
	Hash表
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 0;
        int temp = 0;
        int value = 0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                map.put(nums[i],count+1);
            }else{
                map.put(nums[i],1);
            }
        }
        //map遍历
        for(Integer key:map.keySet()){
            value = map.get(key);
            if(max<value){
                max = value;
                temp = key;
            }
        }
        if(max > nums.length/2){
            return temp;
        }else
            return 0;
    }
}

 /*
	算法思想：
摩尔投票法：
	
	候选人(cand_num)初始化为nums[0]，票数count初始化为1。
	当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
	当票数count为0时，更换候选人，并将票数count重置为1。
	遍历完数组后，cand_num即为最终答案。

	为何这行得通呢？
	投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
	且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
	因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
	这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。

	无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。

 */
 class Solution {
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else {
                if (--count == 0) {
                    cand_num = nums[i];
                    count = 1;
                }
            }
        }
        return cand_num;
    }
}

