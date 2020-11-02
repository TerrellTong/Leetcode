/*
	算法思想：
		我用的双重循环
		还可以将nums1，nums2转成set,用set.contain判断
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums1.length;i++)
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j])
                    set.add(nums1[i]);
            }
            
        int[] res = new int[set.size()];
        int index = 0;
        for(Integer tmp:set){
            res[index++] = tmp;
        }
        return res;
    }
}