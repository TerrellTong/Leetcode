/*
	�㷨˼�룺
		(��ָ���0��ʼ)
		��ָ�����ѭ������������������������valֵ��ͬ���򽫿�ָ���ֵ������ָ���ֵ��Ȼ���ÿ�ָ����ָ��һ����ǰ�ߡ������ָ���һֱ��ǰ��
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
    }
    return i;
    }
}