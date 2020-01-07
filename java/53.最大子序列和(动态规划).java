/*
	�㷨����̬�滮
	˼�룺
		��̬�滮�������ȶ�������б�������ǰ������������к�Ϊ sum�����Ϊ ans
		��� sum > 0����˵�� sum �Խ��������Ч������ sum ���������ϵ�ǰ��������
		��� sum <= 0����˵�� sum �Խ��������Ч������Ҫ�������� sum ֱ�Ӹ���Ϊ��ǰ��������
		ÿ�αȽ� sum �� ans�Ĵ�С�������ֵ��Ϊans�������������ؽ��
		ʱ�临�Ӷȣ�O(n)O(n)
	sum����ǰ����num[i]��ֵ

*/

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums){
            if(sum>0){
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}