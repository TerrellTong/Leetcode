/*
	算法思想：
		使用HashMap，使某一个数组作为参照物
		如果某一个参照物数组，对照HashMap找，如果存在加入数组中，并使count--，当count=0，移除这个key
		
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //确保nums1的长度始终大于nums2的长度
        if(nums1.length < nums2.length)
            return intersect(nums2,nums1);
        //用HashMap存储长度小的数和相应的次数
        Map<Integer,Integer> map = new HashMap();
        for(int num : nums2){
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
        //声明存储数组
        int[] res = new int [nums1.length];
        int idx = 0;
        //将HashMap与nums1进行比较，从而求交集
        for(int num : nums1){
            int count = map.getOrDefault(num,0);
            //如果count > 0，说明存在这个值
            if(count > 0){
                res[idx++] = num;
                count--;
                if(count > 0)
                    map.put(num,count);
                else
                    map.remove(num);
            }
        }
        return Arrays.copyOfRange(res,0,idx);
    }
}





