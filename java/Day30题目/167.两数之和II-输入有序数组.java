/*
	算法思想：
		用HashMap存储，空间换时间O(n)
		但是由于题目是升序排列，因此可以用二分查找进行查找O(nlogn)/双指针进行查找（进行优化）！
		
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //用map存储数字和对应的索引
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target - numbers[i])){
                int idx1 = map.get(target - numbers[i]) < i+1 ? map.get(target - numbers[i]) : i+1;
                int idx2 = idx1 == map.get(target - numbers[i]) ? i+1 : map.get(i);
                return new int[]{idx1,idx2};
            }    
            else
                map.put(numbers[i],i+1);
        }
        return new int[]{};
    }
}





