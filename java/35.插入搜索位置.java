

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
		//������Ԫ��С������ĵ�һ��Ԫ�ؾ�ֱ�Ӳ���
        if(target<=nums[0])
            return 0;
        for(;i<nums.length;i++){
            if(i+1 < nums.length)
                if(nums[i]<=target&&nums[i+1]>=target)
                    return i+1;
        }
        if(i==nums.length)
            return i;
        return -1;
    }
}