/*
	
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int i=length-1;i>=0;i--){
            //��λ����
            digits[i]++;
            int flag = digits[i]%10; 
			//�������flag == 0 (�����Ѿ���λ)���򽫴�Ϊ��Ϊ0
            if(flag != 0) 
                return digits;
            else
                digits[i] = 0;
        }
		//Ϊ���鿪���µĳ��ȵķ�����9,99,999 ��һλԭ��������
        digits = new int [length+1];
        digits[0] = 1;
        return digits;
    }
}

