/*
	�㷨˼�룺
		��ָ����ٵ���ǰ�������������������ָ�벻ͬ����������ָ��ǰ��һλ��Ȼ���ÿ�ָ���ֵ������ָ���ֵ�������ָ���һֱ��ǰ��
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
		//i����ָ��,j�ǿ�ָ��
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}